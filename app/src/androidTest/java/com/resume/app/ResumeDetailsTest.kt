package com.resume.app

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import com.resume.app.resume.view.ResumeAdapter
import org.junit.Test
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers

class ResumeDetailsTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java
    )

    @Test
    fun user_list_recycler_view_click() {
        Thread.sleep(5000) //IdlingResource should be used preferably
        onView(withId(R.id.resume_list_recycler))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(activityRule.getActivity().getWindow().getDecorView())))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ResumeAdapter.ResumeViewHolder>(0, click()))
    }

    @Test
    fun user_list_recycler_view_card_view_visible() {
        Thread.sleep(5000) //IdlingResource should be used preferably
        onView(withId(R.id.resume_list_recycler))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(activityRule.getActivity().getWindow().getDecorView())))
            .check(
                matches(
                    withViewAtPosition(
                        0, Matchers.allOf(
                            withId(R.id.resume_card_view), isDisplayed()
                        )
                    )
                )
            )
    }

    private fun withViewAtPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(recyclerView: RecyclerView): Boolean {
                val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
                return viewHolder != null && itemMatcher.matches(viewHolder.itemView)
            }
        }
    }
}

