package com.example.jorge_caro.daggertest.movieDescription.interactors

import com.example.jorge_caro.daggertest.movieDescription.model.MovieDescription
import com.example.jorge_caro.daggertest.movieDescription.specifications.MovieSpecification
import com.example.jorge_caro.daggertest.repositories.MovieDescriptionRepository
import rx.Observable

/**
 * Created by jorge_caro on 1/10/18.
 */
class MovieDescriptionInteractor(private var repository: MovieDescriptionRepository) {

    fun getMovieDescription(specification: MovieSpecification): Observable<MovieDescription> = repository.query(specification)
}