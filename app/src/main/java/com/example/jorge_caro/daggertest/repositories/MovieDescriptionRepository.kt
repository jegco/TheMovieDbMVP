package com.example.jorge_caro.daggertest.repositories


import com.example.jorge_caro.daggertest.movieDescription.model.MovieDescription
import com.example.jorge_caro.daggertest.movieDescription.specifications.MovieSpecification
import com.example.jorge_caro.test.http.MovieDescriptionApiModel.MovieDescriptionApi
import rx.Observable

/**
 * Created by jorge_caro on 1/10/18.
 */
class MovieDescriptionRepository(private val movieDescriptionApi: MovieDescriptionApi) : Repository<MovieSpecification, MovieDescription> {

    private var movieDescriptionObservable: Observable<MovieDescription>? = null

    override fun add(entity: MovieDescription) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(entities: List<MovieDescription>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(entity: MovieDescription) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(entity: MovieDescription) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun query(specification: MovieSpecification): Observable<MovieDescription> {
        return getFromNetwork(specification)
    }

    override fun getFromNetwork(specification: MovieSpecification): Observable<MovieDescription> {
        movieDescriptionObservable = movieDescriptionApi.getMovieDescription(specification.idMovie, specification.apiKey, specification.language, "videos")
        return movieDescriptionObservable as Observable<MovieDescription>
    }

}