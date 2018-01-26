package com.example.jorge_caro.test.http.MovieDescriptionApiModel


import com.example.jorge_caro.daggertest.movieDescription.model.MovieDescription
import rx.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by jorge_caro on 1/4/18.
 */

interface MovieDescriptionApi {

    @GET("{idMovie}")
    fun getMovieDescription(@Path("idMovie") idMovie: String, @Query("api_key") apiKey: String, @Query("language") language: String, @Query("append_to_response") appendToResponse: String): Observable<MovieDescription>

}
