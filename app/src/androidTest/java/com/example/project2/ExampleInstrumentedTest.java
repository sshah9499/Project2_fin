package com.example.project2;

import android.content.Context;
import android.os.SystemClock;
import android.widget.TextView;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;

import junit.framework.AssertionFailedError;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    //@Test
    //public void useAppContext()
    //{
        // Context of the app under test.
        //Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        //assertEquals("com.example.project2", appContext.getPackageName());
    //}

    @Test
    public void test1() throws Exception
    {
        onView(
                anyOf(withId(R.id.button6))
        ).check(matches(isDisplayed()));

        onView(withText("NEXT")).perform(click());

        onView(
                anyOf(withId(R.id.button2))
        ).check(matches(isDisplayed()));

        try
        {
            onView(withText("This is the Next Screen")).check(matches(isDisplayed()));
            // View is displayed
        }
        catch (AssertionFailedError e)
        {
            // View not displayed
        }

        onView(withText("PREVIOUS")).perform(click());
    }

    @Test
    public void test2() throws Exception
    {
        onView(
            anyOf(withId(R.id.button6))
    ).check(matches(isDisplayed()));

        onView(withText("NEXT")).perform(click());

        onView(
                anyOf(withId(R.id.button2))
        ).check(matches(isDisplayed()));

        try {
            onView(withText("This is the Next Screen")).check(matches(isDisplayed()));
            // View is displayed
        } catch (AssertionFailedError e) {
            // View not displayed
        }

        onView(withText("PREVIOUS")).perform(click());

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(60*1000);
        IdlingRegistry.getInstance().register(idlingResource);
        String text = "Hello World";
        onView(withText(text)).check(matches(isDisplayed()));
        IdlingRegistry.getInstance().unregister(idlingResource);
    }
}
