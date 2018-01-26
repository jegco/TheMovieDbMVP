package com.example.jorge_caro.daggertest.movieDescription

import android.content.Context
import com.example.jorge_caro.daggertest.movieDescription.model.MovieDescription

/**
 * Created by jorge_caro on 1/10/18.
 */
interface MovieDescriptionContract {

    interface View {
        fun refresh(movie: MovieDescription)
        fun showErrorMessage(error: String)
    }

    interface Presenter {
        fun loadDescription(idMovie: String)
        fun watchTrailer(context: Context, url:String)
        fun setView(view: View)
        fun onDestroy()
    }
}