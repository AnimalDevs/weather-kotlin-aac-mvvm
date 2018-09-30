package es.animaldevs.app.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import es.animaldevs.app.model.local.weatherday.WeatherDay
import es.animaldevs.app.model.local.weatherday.WeatherDayDao

@Database(entities = arrayOf(WeatherDay::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDayDao(): WeatherDayDao
}