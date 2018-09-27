package es.animaldevs.app.model.local.weatherday

import es.animaldevs.app.model.network.weatherday.WeatherDayResponse

data class WeatherDays(val dailyForecasts: List<WeatherDay>?) {

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