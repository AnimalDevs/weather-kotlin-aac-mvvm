package es.animaldevs.app.ui.weather

import android.arch.lifecycle.MutableLiveData
import es.animaldevs.app.base.BaseViewModel
import es.animaldevs.app.model.ModelExample

class WeatherViewModel : BaseViewModel() {
    private val image = MutableLiveData<String>()
    private val title = MutableLiveData<String>()
    private val description = MutableLiveData<String>()
    private val points = MutableLiveData<Int>()
    private val totalPoints = MutableLiveData<Int>()

    fun bind(modelExample: ModelExample) {
        image.value = modelExample.image
        title.value = modelExample.title
        description.value = modelExample.description
        points.value = modelExample.points
        totalPoints.value = modelExample.total_points
    }

    fun getImage(): MutableLiveData<String> = image
    fun getTitle(): MutableLiveData<String> = title
    fun getDescription(): MutableLiveData<String> = description
    fun getPoints(): MutableLiveData<Int> = points
    fun getTotalPoints(): MutableLiveData<Int> = totalPoints


}