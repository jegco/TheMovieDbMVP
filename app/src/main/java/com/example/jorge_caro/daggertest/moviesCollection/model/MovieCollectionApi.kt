package com.example.jorge_caro.daggertest.moviesCollection.model


import com.example.jorge_caro.test.http.MovieApi_model.MovieCollection

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface MovieCollectionApi {

    @GET("popular")
    fun getMovies(@Query("api_key") apiKey: String, @Query("language") language: String): Observable<MovieCollection>
}
