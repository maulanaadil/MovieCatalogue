package com.maulnad.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.utils.DataDummy
import com.maulnad.moviecatalogue.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))

        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(withText("Storyboard")))

        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc)).check(matches(withText(dummyMovie[0].description)))

        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_poster2)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))

        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(withText("Storyboard")))

        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc)).check(matches(withText(dummyTvShow[0].description)))

        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun viewTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))

        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))


        onView(withId(R.id.navigation_favourite)).perform(click())
        onView(withText("MOVIES")).perform(click())
        onView(withText("TV SHOWS")).perform(click())

        onView(withId(R.id.navigation_movie)).perform(click())
    }

    @Test
    fun insertAndUpdateFavourite() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.action_favourite)).perform(click())
        pressBack()


        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.action_favourite)).perform(click())
        pressBack()

        onView(withId(R.id.navigation_favourite)).perform(click())
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_fav_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.action_favourite)).perform(click())
        pressBack()

        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_fav_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.action_favourite)).perform(click())
        pressBack()
    }

}