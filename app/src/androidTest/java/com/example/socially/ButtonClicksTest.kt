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
class ButtonClicksTest {

    @Test
    fun testBottomNavigationAndLikeButtonClicks() {
        // Launch MainActivity directly
        ActivityScenario.launch(MainActivity::class.java)

        // Verify we're on home fragment initially
        onView(withId(R.id.topbar))
            .check(matches(isDisplayed()))

        // Test bottom navigation - click on explore tab
        onView(withId(R.id.nav_explore))
            .perform(click())

        // Verify explore fragment is loaded
        onView(withId(R.id.searchBar))
            .check(matches(isDisplayed()))

        // Navigate back to home
        onView(withId(R.id.nav_home))
            .perform(click())

        // Verify home fragment is loaded again
        onView(withId(R.id.topbar))
            .check(matches(isDisplayed()))

        // Test like button functionality
        onView(withId(R.id.like_button))
            .check(matches(isDisplayed()))
            .perform(click())

        // Test second like button
        onView(withId(R.id.like_button2))
            .check(matches(isDisplayed()))
            .perform(click())

        // Test notifications tab
        onView(withId(R.id.nav_notifications))
            .perform(click())

        // Verify notifications fragment is loaded
        onView(withText("Following"))
            .check(matches(isDisplayed()))

        // Test profile tab
        onView(withId(R.id.nav_profile))
            .perform(click())

        // Verify profile fragment elements
        onView(withId(R.id.profile_image))
            .check(matches(isDisplayed()))

        onView(withId(R.id.edit_profile))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testCameraButtonAndDirectMessageNavigation() {
        // Launch MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Test camera button click (should open camera intent)
        onView(withId(R.id.camerabtn))
            .check(matches(isDisplayed()))
            .perform(click())

        // Note: Camera intent will open, but we can't test external apps
        // So we just verify the button is clickable

        // Test IGDirect button click
        onView(withId(R.id.igdirectbtn))
            .check(matches(isDisplayed()))
            .perform(click())

        // Verify IGDirect screen opens
        onView(withText("jacob_w"))
            .check(matches(isDisplayed()))

        // Verify search bar in direct messages
        onView(withText("Search"))
            .check(matches(isDisplayed()))

        // Test back navigation (if back button exists)
        // This would close IGDirect and return to MainActivity
    }
}
