package com.example.jorge_caro.daggertest.moviesCollection.view.recyclerView

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item.view.*

/**
 * Created by jorge_caro on 1/10/18.
 */
class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
     var movieName: TextView
        get() = itemView.movieName
        set(value) = TODO()
    var posterImage: ImageView
        get() = itemView.posterImage
        set(value) = TODO()
    var movie: CardView
        get() = itemView.movie
        set(value) = TODO()

}