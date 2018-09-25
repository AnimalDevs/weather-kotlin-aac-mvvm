package es.animaldevs.app.model

import com.squareup.moshi.Json

data class Maximum(@Json(name = "UnitType")
                   val unitType: Int = 0,
                   @Json(name = "Value")
                   val value: Double = 0.0,
                   @Json(name = "Unit")
                   val unit: String = "")