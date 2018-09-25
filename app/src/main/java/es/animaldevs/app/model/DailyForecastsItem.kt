package es.animaldevs.app.model

import com.squareup.moshi.Json

data class DailyForecastsItem(@Json(name = "Temperature")
                              val temperature: Temperature,
                              @Json(name = "Night")
                              val night: Night,
                              @Json(name = "EpochDate")
                              val epochDate: Int = 0,
                              @Json(name = "Day")
                              val day: Day,
                              @Json(name = "Sources")
                              val sources: List<String>?,
                              @Json(name = "Date")
                              val date: String = "",
                              @Json(name = "Link")
                              val link: String = "",
                              @Json(name = "MobileLink")
                              val mobileLink: String = "")