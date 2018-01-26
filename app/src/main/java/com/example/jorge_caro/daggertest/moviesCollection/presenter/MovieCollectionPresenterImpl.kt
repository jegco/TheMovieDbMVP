package com.example.jorge_caro.daggertest.moviesCollection.presenter

import android.util.Log
import android.widget.ImageView
import com.example.jorge_caro.daggertest.moviesCollection.interactor.MovieCollectionInteractor
import com.example.jorge_caro.daggertest.moviesCollection.MoviesCollectionContract
import com.example.jorge_caro.daggertest.moviesCollection.MoviesCollectionContract.Presenter
import com.example.jorge_caro.daggertest.moviesCollection.specifications.MovieCollectionSpecification
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MovieCollectionPresenterImpl(private val interactor: MovieCollectionInteractor) : Presenter{

    private var view: MoviesCollectionContract.View? = null
    private lateinit var subscription: Subscription
    private lateinit var specification: MovieCollectionSpecification
    var isAsyncRequestDone = false


    override fun loadResult() {
        if (view != null) {
            specification = MovieCollectionSpecification("185e49956bb95f11604e6659ec856903", "en-US")
            subscription = interactor.getMovies(specification)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ result ->
                        view!!.refresh(result)
                        isAsyncRequestDone = true
                    }, { _->
                                view!!.showMessageError()
                            }
                    )
        }
    }

    override fun setView(view: MoviesCollectionContract.View) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun goToDescription(idMovie: String, imageView: ImageView) {
        view!!.goToDescription(idMovie, imageView)
    }

}