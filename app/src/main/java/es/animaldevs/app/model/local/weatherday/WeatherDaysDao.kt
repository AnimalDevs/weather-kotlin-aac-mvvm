package es.animaldevs.app.model.local.weatherday

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface WeatherDaysDao {
    @get:Query("SELECT * FROM WeatherDays")
    val all: WeatherDays

    @Insert
    fun insertAll(vararg items: WeatherDays)

    @Insert
    fun insert(item: WeatherDays)

    @Query("DELETE FROM WeatherDays")
    fun removeAllItems()
}