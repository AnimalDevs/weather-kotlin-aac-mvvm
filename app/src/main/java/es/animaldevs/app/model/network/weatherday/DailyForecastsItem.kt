package es.animaldevs.app.model.network.weatherday

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyForecastsItem(@Json(name = "Temperature")
                              val temperature: Temperature,
                              @Json(name = "EpochDate")
                              val epochDate: Long = 0,
                              @Json(name = "Day")
                              val day: Day)