package com.example.jorge_caro.daggertest.moviesCollection.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.jorge_caro.daggertest.R
import com.example.jorge_caro.daggertest.moviesCollection.view.MoviesCollectionFragment
import com.example.jorge_caro.daggertest.root.App

class MovieCollectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (App.component).inject(this)

        supportFragmentManager.beginTransaction().replace(R.id.container, MoviesCollectionFragment()).commit()
    }
}
