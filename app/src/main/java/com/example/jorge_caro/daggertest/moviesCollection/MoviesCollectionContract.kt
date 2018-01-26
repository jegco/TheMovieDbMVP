package com.example.jorge_caro.daggertest.moviesCollection

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.example.jorge_caro.test.http.MovieApi_model.MovieCollection

/**
 * Created by jorge_caro on 1/9/18.
 */
interface MoviesCollectionContract {

    interface View {
        fun refresh(result: MovieCollection)
        fun show()
        fun hide()
        fun showMessageError()
        fun goToDescription(idMovie: String, imageView: ImageView)
    }

    interface Presenter {
        fun loadResult()
        fun setView(view: View)
        fun onDestroy()
        fun goToDescription(idMovie: String, imageView: ImageView)
    }

}