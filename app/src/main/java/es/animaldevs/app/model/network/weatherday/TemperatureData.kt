package es.animaldevs.app.model.network.weatherday

import com.google.gson.annotations.SerializedName

data class TemperatureData(
//        @SerializedName("Value")
//        val value: Int = 0,
        @SerializedName("Unit")
        val unit: String = "",
        @SerializedName("UnitType")
        val unitType: Int = 0
)