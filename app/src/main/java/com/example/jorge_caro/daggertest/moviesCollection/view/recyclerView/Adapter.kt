package com.example.jorge_caro.daggertest.moviesCollection.view.recyclerView

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.jorge_caro.daggertest.R
import com.example.jorge_caro.daggertest.moviesCollection.presenter.MovieCollectionPresenterImpl
import com.example.jorge_caro.daggertest.root.App
import com.example.jorge_caro.test.http.MovieApi_model.MovieCollection
import javax.inject.Inject

/**
 * Created by jorge_caro on 1/10/18.
 */
class Adapter(private var context: Context, private var movieCollection: MovieCollection,private var activity: AppCompatActivity) : RecyclerView.Adapter<ViewHolder>() {

    @Inject lateinit var presenter: MovieCollectionPresenterImpl

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieName.text= movieCollection.results!![position].title.toString()
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+ movieCollection.results!![position].posterPath).override(400, 400)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.posterImage)
        holder.movie.setOnClickListener { _ ->
            presenter.goToDescription(movieCollection.results!![position].id.toString(), holder.posterImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        (App.component).inject(this)
        return ViewHolder(
                LayoutInflater.from(context).
                        inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int = movieCollection.results!!.size


}