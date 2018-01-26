package com.example.jorge_caro.daggertest.repositories

import com.example.jorge_caro.daggertest.movieDescription.specifications.MovieSpecification
import rx.Observable

/**
 * Created by jorge_caro on 1/9/18.
 */
interface Repository<T, N> {
    fun add(entity: N)
    fun add(entities: List<N>)
    fun remove(entity: N)
    fun update(entity: N)
    fun query(specification: T): Observable<N>
    fun getFromNetwork(specification: T): Observable<N>
}