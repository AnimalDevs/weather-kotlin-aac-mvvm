package es.animaldevs.app.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import androidx.appcompat.app.AppCompatActivity
import es.animaldevs.app.model.database.AppDatabase
import es.animaldevs.app.ui.weather.WeatherListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "clues").build()
            @Suppress("UNCHECKED_CAST")
            return WeatherListViewModel(db.modelExampleDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}