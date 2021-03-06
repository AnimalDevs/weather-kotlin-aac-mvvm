package es.animaldevs.app.model.network.weatherday

import com.google.gson.annotations.SerializedName

data class Day(
        @SerializedName("Icon")
        val icon: Int = 0,
        @SerializedName("IconPhrase")
        val iconPhrase: String = ""
)