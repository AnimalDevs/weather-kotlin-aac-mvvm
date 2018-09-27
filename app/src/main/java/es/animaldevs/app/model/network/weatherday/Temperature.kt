package es.animaldevs.app.model.network.weatherday

import com.squareup.moshi.Json

data class Temperature(@Json(name = "TemperatureData")
                       val minimum: TemperatureData,
                       @Json(name = "Maximum")
                       val maximum: TemperatureData)