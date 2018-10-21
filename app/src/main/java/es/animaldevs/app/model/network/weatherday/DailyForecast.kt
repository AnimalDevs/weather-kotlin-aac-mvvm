package es.animaldevs.app.model.network.weatherday

import com.google.gson.annotations.SerializedName

data class DailyForecast(
        @SerializedName("Date")
        val date: String = "",
        @SerializedName("EpochDate")
        val epochDate: Long = 0,
        @SerializedName("Temperature")
        val temperature: Temperature = Temperature(),
        @SerializedName("Day")
        val day: Day = Day(),
        @SerializedName("Night")
        val night: Night = Night(),
        @SerializedName("Sources")
        val sources: List<String> = listOf(),
        @SerializedName("MobileLink")
        val mobileLink: String = "",
        @SerializedName("Link")
        val link: String = ""
)