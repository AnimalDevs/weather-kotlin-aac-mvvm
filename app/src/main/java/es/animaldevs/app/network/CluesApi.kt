package es.animaldevs.app.network

import es.animaldevs.app.model.ModelExample
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface CluesApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/bins/1bhg84") // /posts
    fun getClues(): Observable<List<ModelExample>>
}