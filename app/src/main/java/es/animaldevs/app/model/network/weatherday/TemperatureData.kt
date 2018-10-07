package es.animaldevs.app.model.network.weatherday

data class TemperatureData(val unitType: Int = 0,
                              val value: Float,
                              val unit: String = "")