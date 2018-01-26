package com.example.jorge_caro.daggertest.moviesCollection.view;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.runner.AndroidJUnit4;

import com.example.jorge_caro.daggertest.ActivityRule;
import com.example.jorge_caro.daggertest.R;
import com.example.jorge_caro.daggertest.RecyclerViewMatcher;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class MovieCollectionTest {

    @Rule
    public ActivityRule<MovieCollectionActivity> movieCollectionActivityActivityRule = new ActivityRule<>(MovieCollectionActivity.class);

    @Test
    public void shouldSeeCardViews() {
        movieCollectionActivityActivityRule.get();
        onView(withId(R.id.container)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        //onData(withRecyclerView(R.id.recycler_view).atPosition(0)).perform(click());
        onView(withId(R.id.containerDescription)).check(matches(isDisplayed()));


    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }
}
