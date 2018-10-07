package es.animaldevs.app.injection

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import es.animaldevs.app.model.database.AppDatabase
import es.animaldevs.app.model.local.weatherday.WeatherDayDao
import javax.inject.Singleton

@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object DBModule {
    @Provides
    @Singleton
    @JvmStatic
    internal fun provideWeatherDayDao(appDatabase: AppDatabase): WeatherDayDao {
        return appDatabase.weatherDayDao()
    }

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideWeatherDayDB(applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(applicationContext, AppDatabase::class.java, "weather_day").build()
    }


}