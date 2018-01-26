package com.example.jorge_caro.daggertest.root

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jorge_caro on 1/9/18.
 */

@Module
class ApplicationModule(private val application: Application) {

    @Provides @Singleton fun provideContext(): Context = application
}