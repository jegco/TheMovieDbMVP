package com.example.jorge_caro.daggertest.moviesCollection.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.jorge_caro.daggertest.moviesCollection.view.recyclerView.Adapter
import android.widget.Toast
import com.example.jorge_caro.daggertest.R
import com.example.jorge_caro.daggertest.movieDescription.view.MovieDescriptionActivity
import com.example.jorge_caro.daggertest.moviesCollection.MoviesCollectionContract
import com.example.jorge_caro.daggertest.moviesCollection.presenter.MovieCollectionPresenterImpl
import com.example.jorge_caro.daggertest.root.App
import com.example.jorge_caro.test.http.MovieApi_model.MovieCollection
import kotlinx.android.synthetic.main.fragment_movies_collection.*
import javax.inject.Inject

class MoviesCollectionFragment : Fragment(), MoviesCollectionContract.View {

    @Inject lateinit var movieCollectionPresenter: MovieCollectionPresenterImpl


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_movies_collection, container, false)
        App.component.inject(this)
        return view
    }

    override fun showMessageError() {
        Toast.makeText(context, "hubo un error", Toast.LENGTH_SHORT)
    }

    override fun refresh(result:MovieCollection) {
        var adapter = Adapter(context, result, activity as AppCompatActivity)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = (GridLayoutManager(context, 2))
        recycler_view.setHasFixedSize(true)
    }

    override fun show() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hide() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToDescription(idMovie: String, imageView: ImageView) {
        val intent = Intent(activity, MovieDescriptionActivity::class.java)
        intent.putExtra("idMovie", idMovie)
            startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        movieCollectionPresenter.setView(this)
        movieCollectionPresenter.loadResult()
    }

    override fun onDestroy() {
        movieCollectionPresenter.onDestroy()
        super.onDestroy()
    }
}
