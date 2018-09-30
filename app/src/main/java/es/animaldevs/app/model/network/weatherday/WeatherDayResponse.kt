package es.animaldevs.app.model.network.weatherday

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
{
"Headline": {
"EffectiveDate": "2017-12-23T08:00:00+02:00",
"EffectiveEpochDate": 1514008800,
"Severity": 7,
"Text": "Mostly sunny this weekend",
"Category": null,
"EndDate": null,
"EndEpochDate": null,
"MobileLink": "http://m.accuweather.com/en/es/madrid/308526/extended-weather-forecast/308526?lang=en-en",
"Link": "http://www.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?lang=en-en"
},
"WeatherDay": [
{
"Date": "2018-09-25T07:00:00+02:00",
"EpochDate": 1537851600,
"Temperature": {
"TemperatureData": {
"Value": 64,
"Unit": "F",
"UnitType": 18
},
"Maximum": {
"Value": 86,
"Unit": "F",
"UnitType": 18
}
},
"Day": {
"Icon": 2,
"IconPhrase": "Mostly sunny"
},
"Night": {
"Icon": 36,
"IconPhrase": "Intermittent clouds"
},
"Sources": [
"AccuWeather"
],
"MobileLink": "http://m.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=1&lang=en-en",
"Link": "http://www.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=1&lang=en-en"
},
{
"Date": "2018-09-26T07:00:00+02:00",
"EpochDate": 1537938000,
"Temperature": {
"TemperatureData": {
"Value": 60,
"Unit": "F",
"UnitType": 18
},
"Maximum": {
"Value": 82,
"Unit": "F",
"UnitType": 18
}
},
"Day": {
"Icon": 17,
"IconPhrase": "Partly sunny w/ t-storms"
},
"Night": {
"Icon": 35,
"IconPhrase": "Partly cloudy"
},
"Sources": [
"AccuWeather"
],
"MobileLink": "http://m.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=2&lang=en-en",
"Link": "http://www.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=2&lang=en-en"
},
{
"Date": "2018-09-27T07:00:00+02:00",
"EpochDate": 1538024400,
"Temperature": {
"TemperatureData": {
"Value": 57,
"Unit": "F",
"UnitType": 18
},
"Maximum": {
"Value": 81,
"Unit": "F",
"UnitType": 18
}
},
"Day": {
"Icon": 3,
"IconPhrase": "Partly sunny"
},
"Night": {
"Icon": 33,
"IconPhrase": "Clear"
},
"Sources": [
"AccuWeather"
],
"MobileLink": "http://m.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=3&lang=en-en",
"Link": "http://www.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=3&lang=en-en"
},
{
"Date": "2018-09-28T07:00:00+02:00",
"EpochDate": 1538110800,
"Temperature": {
"TemperatureData": {
"Value": 61,
"Unit": "F",
"UnitType": 18
},
"Maximum": {
"Value": 86,
"Unit": "F",
"UnitType": 18
}
},
"Day": {
"Icon": 3,
"IconPhrase": "Partly sunny"
},
"Night": {
"Icon": 34,
"IconPhrase": "Mostly clear"
},
"Sources": [
"AccuWeather"
],
"MobileLink": "http://m.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=4&lang=en-en",
"Link": "http://www.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=4&lang=en-en"
},
{
"Date": "2018-09-29T07:00:00+02:00",
"EpochDate": 1538197200,
"Temperature": {
"TemperatureData": {
"Value": 57,
"Unit": "F",
"UnitType": 18
},
"Maximum": {
"Value": 85,
"Unit": "F",
"UnitType": 18
}
},
"Day": {
"Icon": 1,
"IconPhrase": "Sunny"
},
"Night": {
"Icon": 34,
"IconPhrase": "Mostly clear"
},
"Sources": [
"AccuWeather"
],
"MobileLink": "http://m.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=5&lang=en-en",
"Link": "http://www.accuweather.com/en/es/madrid/308526/daily-weather-forecast/308526?day=5&lang=en-en"
}
]
}
 *
 */
@JsonClass(generateAdapter = true)
data class WeatherDayResponse(@Json(name = "DailyForecasts")
                              val dailyForecasts: List<DailyForecastsItem>?)