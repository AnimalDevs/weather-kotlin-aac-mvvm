package es.animaldevs.app.model.local.weatherday

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface WeatherDayDao {
    @get:Query("SELECT * FROM WeatherDay")
    val all: WeatherDay

    @Insert
    fun insertAll(vararg items: WeatherDay)

    @Insert
    fun insert(item: WeatherDay)

    @Query("DELETE FROM WeatherDay")
    fun removeAllItems()
}