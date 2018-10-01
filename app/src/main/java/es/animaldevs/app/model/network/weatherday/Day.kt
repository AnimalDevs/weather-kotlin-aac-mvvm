package es.animaldevs.app.model.network.weatherday

import com.squareup.moshi.Json

data class Day(@Json(name = "IconPhrase")
               val iconPhrase: String = "",
               @Json(name = "Icon")
               val icon: Int = 0)