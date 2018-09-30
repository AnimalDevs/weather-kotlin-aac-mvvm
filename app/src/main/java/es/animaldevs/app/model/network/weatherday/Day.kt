package es.animaldevs.app.model.network.weatherday

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Day(@Json(name = "IconPhrase")
               val iconPhrase: String = "",
               @Json(name = "Icon")
               val icon: Int = 0)