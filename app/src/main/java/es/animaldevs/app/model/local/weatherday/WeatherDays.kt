package es.animaldevs.app.model.local.weatherday

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import es.animaldevs.app.model.network.weatherday.WeatherDayResponse

@Entity
data class WeatherDays(@PrimaryKey(autoGenerate = true)
                      val dailyForecasts: List<WeatherDay>?) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    object Map {
        fun from(response: WeatherDayResponse) =
                WeatherDays(toWeatherDay(response))

        private fun toWeatherDay(response: WeatherDayResponse): List<WeatherDay>? {
            val list: MutableList<WeatherDay> = mutableListOf()

            response.dailyForecasts?.forEach { i -> list.add(WeatherDay.Map.from(i)) }

            return list
        }
    }
}