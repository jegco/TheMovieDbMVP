package com.example.jorge_caro.daggertest.http

import com.example.jorge_caro.daggertest.movieDescription.interactors.MovieDescriptionInteractor
import com.example.jorge_caro.daggertest.movieDescription.presenter.MovieDescriptionPresenterImpl
import com.example.jorge_caro.daggertest.repositories.MovieDescriptionRepository
import com.example.jorge_caro.daggertest.moviesCollection.interactor.MovieCollectionInteractor
import com.example.jorge_caro.daggertest.moviesCollection.model.MovieCollectionApi
import com.example.jorge_caro.daggertest.moviesCollection.presenter.MovieCollectionPresenterImpl
import com.example.jorge_caro.daggertest.repositories.MovieCollectionRepository
import com.example.jorge_caro.test.http.MovieDescriptionApiModel.MovieDescriptionApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by jorge_caro on 1/9/18.
 */

@Module
class MovieApiModule {

    val baseUrl : String = "https://api.themoviedb.org/3/movie/"

    @Provides
    fun providesClient() : OkHttpClient {

        var interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    }

    @Provides
    fun providesRetrofit(baseUrl: String, client: OkHttpClient) : Retrofit = Retrofit.Builder().
            baseUrl(baseUrl).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
            addConverterFactory(GsonConverterFactory.create()).
            client(client).
            build()


    @Provides @Singleton fun providesMovieCollectionApiService(): MovieCollectionApi = providesRetrofit(baseUrl, providesClient()).create(MovieCollectionApi::class.java)

    @Provides @Singleton fun providesCollectionPresenter(interactor: MovieCollectionInteractor): MovieCollectionPresenterImpl =  MovieCollectionPresenterImpl(interactor)

    @Provides @Singleton fun providesCollectionInteractor(repository: MovieCollectionRepository): MovieCollectionInteractor = MovieCollectionInteractor(repository)

    @Provides @Singleton fun providesCollectionRepository(api: MovieCollectionApi): MovieCollectionRepository = MovieCollectionRepository(api)

    @Provides @Singleton fun providesDescriptionPresenter(interactor: MovieDescriptionInteractor): MovieDescriptionPresenterImpl = MovieDescriptionPresenterImpl(interactor)

    @Provides @Singleton fun providesDescriptionInteractor(repository: MovieDescriptionRepository): MovieDescriptionInteractor = MovieDescriptionInteractor(repository)

    @Provides @Singleton fun providesDescriptionRepository(api: MovieDescriptionApi): MovieDescriptionRepository = MovieDescriptionRepository(api)

    @Provides @Singleton fun providesMovieDescriptionApiService(): MovieDescriptionApi = providesRetrofit(baseUrl, providesClient()).create(MovieDescriptionApi::class.java)



}