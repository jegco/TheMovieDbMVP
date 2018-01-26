package com.example.jorge_caro.daggertest.movieDescription.presenter

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.jorge_caro.daggertest.movieDescription.interactors.MovieDescriptionInteractor
import com.example.jorge_caro.daggertest.movieDescription.MovieDescriptionContract
import com.example.jorge_caro.daggertest.movieDescription.specifications.MovieSpecification
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by jorge_caro on 1/10/18.
 */
class MovieDescriptionPresenterImpl(private var interactor: MovieDescriptionInteractor) : MovieDescriptionContract.Presenter {

    private var view: MovieDescriptionContract.View? = null
    private lateinit var subscription: Subscription
    private lateinit var specification: MovieSpecification

    override fun loadDescription(idMovie: String) {
        if (view != null){
            specification = MovieSpecification("185e49956bb95f11604e6659ec856903", "en-US", idMovie)
            subscription = interactor.getMovieDescription(specification).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ result -> view!!.refresh(result)
                    }, {
                        error -> view!!.showErrorMessage(error.message.toString())
                    })
        }
    }

    override fun watchTrailer(context: Context, url: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + url))
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + url))
        try {
            context.startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            context.startActivity(webIntent)
        }
    }

    override fun setView(view: MovieDescriptionContract.View) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
    }
}