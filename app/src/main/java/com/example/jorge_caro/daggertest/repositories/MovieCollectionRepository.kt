package com.example.jorge_caro.daggertest.repositories

import rx.Observable
import com.example.jorge_caro.daggertest.moviesCollection.model.MovieCollectionApi
import com.example.jorge_caro.daggertest.moviesCollection.specifications.MovieCollectionSpecification
import com.example.jorge_caro.test.http.MovieApi_model.MovieCollection

/**
 * Created by jorge_caro on 1/9/18.
 */
class MovieCollectionRepository(private val collectionApi: MovieCollectionApi): Repository<MovieCollectionSpecification, MovieCollection> {

    private var movieCollection: Observable<MovieCollection>? = null
    private var timespan: Long = 0

    private val isUpToUpdate: Boolean
        get() = System.currentTimeMillis() - timespan < TIME_STATE

    override fun getFromNetwork(specification: MovieCollectionSpecification): Observable<MovieCollection>  {
        movieCollection = collectionApi.getMovies(specification.apiKey, specification.languaje)
        return movieCollection as Observable<MovieCollection>
    }

    private fun getFromMemory(): Observable<MovieCollection> {
        return if (!isUpToUpdate && movieCollection != null) movieCollection as Observable<MovieCollection>
        else{
            timespan = System.currentTimeMillis()
            Observable.empty()
        }
    }

    override fun add(entity: MovieCollection) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(entities: List<MovieCollection>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(entity: MovieCollection) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(entity: MovieCollection) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun query(specification: MovieCollectionSpecification): Observable<MovieCollection> = getFromMemory().switchIfEmpty(getFromNetwork(specification))


    companion object {

        private val TIME_STATE = (20 * 1000).toLong()
    }

}