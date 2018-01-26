package com.example.jorge_caro.daggertest.moviesCollection.interactor

import com.example.jorge_caro.daggertest.moviesCollection.specifications.MovieCollectionSpecification
import com.example.jorge_caro.daggertest.repositories.MovieCollectionRepository
import com.example.jorge_caro.test.http.MovieApi_model.MovieCollection
import rx.Observable

/**
 * Created by jorge_caro on 1/9/18.
 */
class MovieCollectionInteractor(private val repository: MovieCollectionRepository) {

    fun getMovies(specification: MovieCollectionSpecification): Observable<MovieCollection> = repository.query(specification)

}