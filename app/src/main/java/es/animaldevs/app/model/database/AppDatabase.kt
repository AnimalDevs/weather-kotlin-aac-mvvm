package es.animaldevs.app.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import es.animaldevs.app.model.local.weatherday.WeatherDayDao
import es.animaldevs.app.model.local.weatherday.WeatherDays

@Database(entities = arrayOf(WeatherDays::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun modelExampleDao(): WeatherDayDao
}