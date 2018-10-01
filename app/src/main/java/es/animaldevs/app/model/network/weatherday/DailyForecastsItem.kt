package es.animaldevs.app.model.network.weatherday

import com.squareup.moshi.Json

data class DailyForecastsItem(@Json(name = "Temperature")
                              val temperature: Temperature,
                              @Json(name = "EpochDate")
                              val epochDate: Long = 0,
                              @Json(name = "Day")
                              val day: Day)