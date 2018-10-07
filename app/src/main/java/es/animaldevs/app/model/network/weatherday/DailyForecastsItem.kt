package es.animaldevs.app.model.network.weatherday

data class DailyForecastsItem(val temperature: Temperature,
                              val epochDate: Long = 0,
                              val day: Day)