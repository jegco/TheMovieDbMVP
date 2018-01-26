package com.example.jorge_caro.daggertest.root

import com.example.jorge_caro.daggertest.moviesCollection.view.MovieCollectionActivity
import com.example.jorge_caro.daggertest.movieDescription.presenter.MovieDescriptionPresenterImpl
import com.example.jorge_caro.daggertest.movieDescription.view.DescriptionFragment
import com.example.jorge_caro.daggertest.movieDescription.view.list.ListAdapter
import com.example.jorge_caro.daggertest.http.MovieApiModule
import com.example.jorge_caro.daggertest.movieDescription.view.MovieDescriptionActivity
import com.example.jorge_caro.daggertest.moviesCollection.presenter.MovieCollectionPresenterImpl
import com.example.jorge_caro.daggertest.moviesCollection.view.MoviesCollectionFragment
import com.example.jorge_caro.daggertest.moviesCollection.view.recyclerView.Adapter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jorge_caro on 1/9/18.
 */

@Singleton
@Component(modules = [ApplicationModule::class, MovieApiModule::class])
interface ApplicationComponent {

    fun inject(target: MovieCollectionActivity)

    fun inject(target: MoviesCollectionFragment)

    fun inject(target: MovieCollectionPresenterImpl)

    fun inject(target: MovieDescriptionPresenterImpl)

    fun inject(target: DescriptionFragment)

    fun inject(target: ListAdapter)

    fun inject(target: Adapter)

    fun inject(target: MovieDescriptionActivity)

}