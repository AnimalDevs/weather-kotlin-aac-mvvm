package es.animaldevs.app.model.network.weatherday

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
        @SerializedName("Headline")
        val headline: Headline = Headline(),
        @SerializedName("DailyForecasts")
        val dailyForecasts: List<DailyForecast> = listOf()
)