package es.animaldevs.app.model.local.weatherday

import es.animaldevs.app.model.network.weatherday.WeatherResponse

data class WeatherDays(val dailyForecasts: List<WeatherDay>?) {

    object Map {
        fun from(response: WeatherResponse) =
                WeatherDays(toWeatherDay(response))

        private fun toWeatherDay(response: WeatherResponse): List<WeatherDay>? {
            val list: MutableList<WeatherDay> = mutableListOf()

            response.dailyForecasts.forEach { i -> list.add(WeatherDay.Map.from(i)) }

            return list
        }
    }
}