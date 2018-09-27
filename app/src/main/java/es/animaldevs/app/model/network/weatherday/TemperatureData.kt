package es.animaldevs.app.model.network.weatherday

import com.squareup.moshi.Json

data class TemperatureData(@Json(name = "UnitType")
                   val unitType: Int = 0,
                           @Json(name = "Value")
                   val value: Double = 0.0,
                           @Json(name = "Unit")
                   val unit: String = "")