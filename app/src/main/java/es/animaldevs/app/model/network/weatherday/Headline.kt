package es.animaldevs.app.model.network.weatherday

import com.google.gson.annotations.SerializedName

data class Headline(
        @SerializedName("EffectiveDate")
        val effectiveDate: String = "",
        @SerializedName("EffectiveEpochDate")
        val effectiveEpochDate: Int = 0,
        @SerializedName("Severity")
        val severity: Int = 0,
        @SerializedName("Text")
        val text: String = "",
        @SerializedName("Category")
        val category: String = "",
        @SerializedName("EndDate")
        val endDate: String = "",
        @SerializedName("EndEpochDate")
        val endEpochDate: Int = 0,
        @SerializedName("MobileLink")
        val mobileLink: String = "",
        @SerializedName("Link")
        val link: String = ""
)