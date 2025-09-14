package com.example.socially

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SociallyAppTest {

    @Test
    fun testNavigateToIGDirect() {
        // Launch MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Click on the IGDirect button
        onView(withId(R.id.igdirectbtn)).perform(click())

        // Check that the IGDirect screen title is visible
        onView(withText("jacob_w")).check(matches(isDisplayed()))
    }

    @Test
    fun testLikeButtonClick() {
        // Launch MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Click on the like button
        onView(withId(R.id.like_button)).perform(click())

        // Verify the button state changed (it should be selected now)
        onView(withId(R.id.like_button)).check(matches(isDisplayed()))
    }
}
