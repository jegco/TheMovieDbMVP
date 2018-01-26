package com.example.jorge_caro.daggertest.moviesCollection.view;

import android.os.Handler;
import android.support.test.espresso.IdlingResource;

/**
 * Created by jorge_caro on 1/26/18.
 */

public class MovieCollectionIdliResource implements IdlingResource {

    private MovieCollectionActivity activity;
    private ResourceCallback callback;


    private static final int IDLE_POLL_DELAY_MILLIS = 300;

    public MovieCollectionIdliResource(MovieCollectionActivity activity) {
        this.activity = activity;
    }

    @Override
    public String getName() {
        return "MovieCollectionActivityIdleName";
    }

    @Override
    public boolean isIdleNow() {
        Boolean idle = isIdle();
        if (idle) callback.onTransitionToIdle();
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isIdleNow();
                }
            }, IDLE_POLL_DELAY_MILLIS);
        }
        return idle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.callback = callback;
    }

    public boolean isIdle() {
        return (activity != null) && (callback != null) && activity.isAsyncRequestDone();
    }
}
