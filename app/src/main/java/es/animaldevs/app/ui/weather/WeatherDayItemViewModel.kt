package es.animaldevs.app.ui.weather

import android.arch.lifecycle.MutableLiveData
import es.animaldevs.app.base.BaseViewModel
import es.animaldevs.app.model.local.weatherday.WeatherDay

class WeatherDayItemViewModel : BaseViewModel() {
    val nameDay = MutableLiveData<String>()
    val dayAndMonth = MutableLiveData<String>()
    val icon = MutableLiveData<Int>()
    val temperatureMin = MutableLiveData<String>()
    val temperatureMax = MutableLiveData<String>()

    fun bind(item: WeatherDay) {
        nameDay.value = item.nameDay
        dayAndMonth.value = item.dayAndMonth
        icon.value = item.icon
        temperatureMin.value = item.temperatureMin
        temperatureMax.value = item.temperatureMax
    }
}