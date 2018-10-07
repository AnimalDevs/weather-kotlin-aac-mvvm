package es.animaldevs.app.ui.weather

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View
import es.animaldevs.app.BuildConfig
import es.animaldevs.app.R
import es.animaldevs.app.injection.Injector
import es.animaldevs.app.model.local.weatherday.WeatherDay
import es.animaldevs.app.model.local.weatherday.WeatherDayDao
import es.animaldevs.app.model.local.weatherday.WeatherDays
import es.animaldevs.app.network.AccuWeatherApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


class WeatherListViewModel
@Inject constructor(
        private val weatherDayDao: WeatherDayDao,
        private val accuWeatherApi: AccuWeatherApi
) : ViewModel(), WeatherDayListAdapter.Callbacks {

    val weatherDayListAdapter: WeatherDayListAdapter = WeatherDayListAdapter(this)

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val itemSelected: MutableLiveData<WeatherDay> = MutableLiveData()

    val errorClickListener = View.OnClickListener { loadWeathers() }

    private lateinit var subscription: Disposable

    init {
        Injector.get().inject(this)
        loadWeathers()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadWeathers() {
        subscription = accuWeatherApi.getWeatherDays("308526", BuildConfig.API_KEY, "es-es", "false", "true")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveWeatherListStart() }
                .doOnTerminate { onRetrieveWeatherListFinish() }
                .subscribe({ result ->
                    onRetrieveWeatherListSuccess(WeatherDays.Map.from(result))
                },
                        { error ->
                            onRetrieveWeatherListError(error)
                        })
    }

    private fun onRetrieveWeatherListStart() {
        Timber.d("----------->onRetrieveWeatherListStart")
        loadingVisibility.postValue(View.VISIBLE)
        errorMessage.postValue(null)
    }

    private fun onRetrieveWeatherListFinish() {
        Timber.d("----------->onRetrieveWeatherListFinish")
        loadingVisibility.postValue(View.GONE)
    }

    private fun onRetrieveWeatherListSuccess(items: WeatherDays) {
        Timber.d("----------->onRetrieveWeatherListSuccess")

        items.dailyForecasts?.forEach {
            Timber.d("----------->%s", it.dayAndMonth)
        }

        weatherDayListAdapter.updateWeatherList(items.dailyForecasts)
    }


    private fun onRetrieveWeatherListError(error: Throwable) {
        Timber.d("----------->onRetrieveWeatherListError: %s", error)

        errorMessage.postValue(R.string.item_error)
    }

    override fun onItemClick(view: View, item: WeatherDay) {
        itemSelected.postValue(item)
    }
}