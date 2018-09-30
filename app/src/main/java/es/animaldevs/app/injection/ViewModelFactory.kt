package es.animaldevs.app.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import es.animaldevs.app.model.database.AppDatabase
import es.animaldevs.app.ui.weather.WeatherListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "clues").build()
            @Suppress("UNCHECKED_CAST")
            return WeatherListViewModel(db.weatherDayDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}