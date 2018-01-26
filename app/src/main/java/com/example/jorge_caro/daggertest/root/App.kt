package com.example.jorge_caro.daggertest.root

import android.app.Application
import com.example.jorge_caro.daggertest.http.MovieApiModule

/**
 * Created by jorge_caro on 1/9/18.
 */

class App : Application() {

    companion object {
        @JvmStatic lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .movieApiModule(MovieApiModule())
                .build()
    }
}
