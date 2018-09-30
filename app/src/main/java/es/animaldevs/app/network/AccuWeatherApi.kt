package es.animaldevs.app.network

import es.animaldevs.app.model.network.weatherday.WeatherDayResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * The interface which provides methods to get result of webservices
 */
interface AccuWeatherApi {
    @GET("/forecasts/v1/daily/5day/{location_key}")
    fun getWeatherDays(
            @Path("location_key") locationKey: String,
            @Query("apikey") apiKey: String,
            @Query("language") language: String,
            @Query("details") details: String,
            @Query("metric") metric: String
    ): Observable<WeatherDayResponse>

}