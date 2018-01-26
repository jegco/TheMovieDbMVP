package com.example.jorge_caro.daggertest.movieDescription.view.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.example.jorge_caro.daggertest.movieDescription.model.Results
import com.example.jorge_caro.daggertest.movieDescription.model.Videos
import com.example.jorge_caro.daggertest.movieDescription.presenter.MovieDescriptionPresenterImpl
import com.example.jorge_caro.daggertest.R
import com.example.jorge_caro.daggertest.root.App
import kotlinx.android.synthetic.main.list_template.view.*
import javax.inject.Inject

/**
 * Created by jorge_caro on 1/10/18.
 */
class ListAdapter(context: Context, private var trailers: List<Results>?) : ArrayAdapter<Videos>(context, R.layout.list_template) {

    private lateinit var view: View

    var trailerName : TextView
        get() = view.trailerName
        set(value) = TODO()
    var trailer: LinearLayout
        get() = view.trailer
        set(value) = TODO()

    @Inject lateinit var presenter: MovieDescriptionPresenterImpl

    override fun getCount(): Int = trailers!!.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        view = LayoutInflater.from(context).inflate(R.layout.list_template, null)
        (App.component).inject(this)
        trailerName.text = trailers!![position].name
        trailer.setOnClickListener({_ -> presenter.watchTrailer(context, trailers!![position].key.toString())})
        return view
    }

}