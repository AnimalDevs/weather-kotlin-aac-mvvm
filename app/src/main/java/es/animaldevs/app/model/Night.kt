package es.animaldevs.app.model

import com.squareup.moshi.Json

data class Night(@Json(name = "IconPhrase")
                 val iconPhrase: String = "",
                 @Json(name = "Icon")
                 val icon: Int = 0)