package com.example.jorge_caro.daggertest.movieDescription.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jorge_caro.daggertest.R
import com.example.jorge_caro.daggertest.root.App
import kotlinx.android.synthetic.main.activity_movie_description.*

class MovieDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_description)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        (App.component).inject(this)

        var fragment = DescriptionFragment()
        var idMovie = intent.getStringExtra("idMovie")
        var args = Bundle()
        args.putString("idMovie", idMovie.toString())
        fragment.arguments = args
        supportFragmentManager.beginTransaction().replace(R.id.containerDescription, fragment).commit()
    }
}
