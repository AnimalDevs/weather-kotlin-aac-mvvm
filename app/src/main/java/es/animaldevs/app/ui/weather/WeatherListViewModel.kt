package es.animaldevs.app.ui.weather

import androidx.lifecycle.MutableLiveData
import android.view.View
import com.squareup.moshi.Moshi
import es.animaldevs.app.R
import es.animaldevs.app.base.BaseViewModel
import es.animaldevs.app.model.ModelExample
import es.animaldevs.app.model.ModelExampleDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class WeatherListViewModel(private val modelExampleDao: ModelExampleDao) : BaseViewModel(), WeatherListAdapter.Callbacks {

    @Inject
    lateinit var moshi: Moshi

    val weatherListAdapter: WeatherListAdapter = WeatherListAdapter(this)

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val qrButtonVisibility: MutableLiveData<Int> = MutableLiveData()
    val qrCameraVisibility: MutableLiveData<Int> = MutableLiveData()
    val points: MutableLiveData<Int> = MutableLiveData()
    val totalPoints: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val alertMessage: MutableLiveData<Int> = MutableLiveData()
    val modelExampleSelected: MutableLiveData<ModelExample> = MutableLiveData()

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
        subscription = Observable.fromCallable { modelExampleDao.all }
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

    private fun onRetrieveWeatherListSuccess(modelExampleList: List<ModelExample>) {
        weatherListAdapter.updateWeatherList(modelExampleList)
        if (modelExampleList.isNotEmpty()) {

        }
    }


    private fun onRetrieveWeatherListError() {
        errorMessage.postValue(R.string.item_error)
    }

    override fun onItemClick(view: View, item: ModelExample) {
        modelExampleSelected.postValue(item)
    }

    fun removeAllClues() {
        Observable.just(modelExampleDao)
                .subscribeOn(Schedulers.io())
                .subscribe { db ->
                    db.removeAllModelExamples()
                    loadWeathers()
                }
    }
}