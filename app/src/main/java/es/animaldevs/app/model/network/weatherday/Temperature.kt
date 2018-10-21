package es.animaldevs.app.model.network.weatherday

import com.google.gson.annotations.SerializedName

data class Temperature(
        @SerializedName("Minimum")
        val minimum: TemperatureData = TemperatureData(),
        @SerializedName("Maximum")
        val maximum: TemperatureData = TemperatureData()
)