package com.example.jorge_caro.daggertest.moviesCollection.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jorge_caro.daggertest.R
import com.example.jorge_caro.daggertest.moviesCollection.presenter.MovieCollectionPresenterImpl
import com.example.jorge_caro.daggertest.root.App
import javax.inject.Inject

class MovieCollectionActivity : AppCompatActivity() {

    @Inject lateinit var movieCollectionPresenter: MovieCollectionPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (App.component).inject(this)

        supportFragmentManager.beginTransaction().replace(R.id.container, MoviesCollectionFragment()).commit()
    }
    fun isAsyncRequestDone() = movieCollectionPresenter.isAsyncRequestDone
}
