package es.animaldevs.app.model

import com.squareup.moshi.Json

data class Temperature(@Json(name = "Minimum")
                       val minimum: Minimum,
                       @Json(name = "Maximum")
                       val maximum: Maximum)