package es.animaldevs.app.ui.weather

import android.arch.lifecycle.MutableLiveData
import android.view.View
import es.animaldevs.app.R
import es.animaldevs.app.base.BaseViewModel
import es.animaldevs.app.model.local.weatherday.WeatherDay
import es.animaldevs.app.model.local.weatherday.WeatherDays
import es.animaldevs.app.model.local.weatherday.WeatherDaysDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class WeatherListViewModel(private val weatherDaysDao: WeatherDaysDao) : BaseViewModel(), WeatherDayListAdapter.Callbacks {

    val weatherDayListAdapter: WeatherDayListAdapter = WeatherDayListAdapter(this)

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val itemSelected: MutableLiveData<WeatherDay> = MutableLiveData()

    val errorClickListener = View.OnClickListener { loadWeathers() }

    private lateinit var subscription: Disposable

    init {
        loadWeathers()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadWeathers() {
        subscription = Observable.fromCallable { weatherDaysDao.all }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveWeatherListStart() }
                .doOnTerminate { onRetrieveWeatherListFinish() }
                .subscribe { result -> onRetrieveWeatherListSuccess(result) }
    }

    private fun onRetrieveWeatherListStart() {
        loadingVisibility.postValue(View.VISIBLE)
        errorMessage.postValue(null)
    }

    private fun onRetrieveWeatherListFinish() {
        loadingVisibility.postValue(View.GONE)
    }

    private fun onRetrieveWeatherListSuccess(items: WeatherDays) {
        weatherDayListAdapter.updateWeatherList(items.dailyForecasts)
    }


    private fun onRetrieveWeatherListError() {
        errorMessage.postValue(R.string.item_error)
    }

    override fun onItemClick(view: View, item: WeatherDay) {
        itemSelected.postValue(item)
    }
}