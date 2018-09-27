package es.animaldevs.app.model.local.weatherday

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import es.animaldevs.app.model.network.weatherday.DailyForecastsItem
import es.animaldevs.app.model.network.weatherday.TemperatureData
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

@Entity
data class WeatherDay(
        val nameDay: String,
        val dayAndMonth: String,
        val temperatureMin: String,
        val temperatureMax: String,
        val icon: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    object Map {
        fun from(response: DailyForecastsItem) =
                WeatherDay(toDayNameDate(response.epochDate),
                        toDayAndMonth(response.epochDate),
                        toSimpleTemperature(response.temperature.minimum),
                        toSimpleTemperature(response.temperature.maximum),
                        response.day.icon)

        //TODO Sacar esto a clase de utils
        private fun toSimpleTemperature(temp: TemperatureData): String {
            return String.format("%d %s", temp.value, temp.unit)
        }

        fun toDayNameDate(epoch: Long): String {
            val stamp = Timestamp(epoch)
            val date = Date(stamp.time)
            val format = SimpleDateFormat("EEE", Locale("ES"))
            return format.format(date)
        }

        fun toDayAndMonth(epoch: Long): String {
            val stamp = Timestamp(epoch)
            val date = Date(stamp.time)
            val format = SimpleDateFormat("dd MMM", Locale("ES"))
            return format.format(date)
        }
    }
}

