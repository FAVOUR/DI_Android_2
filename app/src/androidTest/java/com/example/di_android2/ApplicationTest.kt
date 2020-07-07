package com.example.di_android2

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.di_android2.main.MainActivity
import org.junit.Test

class ApplicationTest {


    @Test
    fun runApp(){
        ActivityScenario.launch(MainActivity::class.java)

        // Should be in Registration/EnterDetails because the user is not registered
        onView(withText("Register to Dagger World!")).check(matches(isDisplayed()))
        onView(withId(R.id.username)).perform(typeText("UserName"), closeSoftKeyboard())
        onView(withId(R.id.password)).perform(typeText("Password"), closeSoftKeyboard())
        onView(withId(R.id.next)).perform(click())

        //TermsAndCondition Activity
        onView(withText("Terms and Conditions")).check(matches(isDisplayed()))
        onView(withId(R.id.next)).perform(click())

        //MainActivity
        onView(withText("Hello UserName!")).check(matches(isDisplayed()))
        onView(withId(R.id.settings)).perform(click())

    }

}