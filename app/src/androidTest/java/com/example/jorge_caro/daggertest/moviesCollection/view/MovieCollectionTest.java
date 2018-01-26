package com.example.jorge_caro.daggertest.moviesCollection.view;


import android.support.test.espresso.Espresso;
import android.support.test.runner.AndroidJUnit4;

import com.example.jorge_caro.daggertest.ActivityRule;
import com.example.jorge_caro.daggertest.R;
import com.example.jorge_caro.daggertest.RecyclerViewMatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MovieCollectionTest {

    private MovieCollectionIdliResource idlingResource;

    @Rule
    public ActivityRule<MovieCollectionActivity> movieCollectionActivityActivityRule = new ActivityRule<>(MovieCollectionActivity.class);

    @Before
    public void registerIntentServiceIdlingResource() {
        MovieCollectionActivity activity = movieCollectionActivityActivityRule.get();
        idlingResource = new MovieCollectionIdliResource(activity);
        Espresso.registerIdlingResources(idlingResource);
    }

    @After
    public void unregisterIntentServiceIdlingResource() {
        Espresso.unregisterIdlingResources(idlingResource);
    }

    @Test
    public void shouldSeeCardViews() {
        movieCollectionActivityActivityRule.get();
        onView(withId(R.id.container)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
        onView(withRecyclerView(R.id.recycler_view).atPosition(0)).check(matches(withId(R.id.movie)));
        onView(withRecyclerView(R.id.recycler_view).atPosition(0)).perform(click());
        onView(withId(R.id.containerDescription)).check(matches(isDisplayed()));
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

}
