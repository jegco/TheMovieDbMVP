package com.example.jorge_caro.daggertest.movieDescription.view

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.jorge_caro.daggertest.movieDescription.model.MovieDescription
import com.example.jorge_caro.daggertest.movieDescription.MovieDescriptionContract
import com.example.jorge_caro.daggertest.movieDescription.presenter.MovieDescriptionPresenterImpl
import com.example.jorge_caro.daggertest.movieDescription.view.list.ListAdapter
import com.example.jorge_caro.daggertest.R
import com.example.jorge_caro.daggertest.root.App
import kotlinx.android.synthetic.main.activity_movie_description.*
import kotlinx.android.synthetic.main.activity_movie_description.view.*
import kotlinx.android.synthetic.main.fragment_description.*
import javax.inject.Inject


class DescriptionFragment : Fragment(), MovieDescriptionContract.View {
    override fun showErrorMessage(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject lateinit var presenter: MovieDescriptionPresenterImpl

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_description, container, false)
        //(App.component).inject(this)
        (App.component).inject(this)
        return view
    }

    override fun onStart() {
        super.onStart()
        presenter.setView(this)
        presenter.loadDescription(arguments.getString("idMovie"))
    }



    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun refresh(movie: MovieDescription) {
        overview.text =  movie.overview
        budget.text = Html.fromHtml("<b>Budget:</b>  "  + movie.budget.toString())
        release_date.text = Html.fromHtml("<b>Release date:</b>   " + movie.releaseDate)
        movieVoteAverage.text = Html.fromHtml("<b>Vote average:</b>   " + movie.voteAverage.toString())
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+ movie.posterPath).override(800, 800)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(posterImage)
        trailers.adapter = ListAdapter(context, movie.videos!!.results)
        (activity as AppCompatActivity).toolbar.title = movie.title
    }

}