package com.example.di_android2.user

import com.example.di_android2.di.subcomponents.user.UserComponent
import com.example.di_android2.storage.FakeStorage
import com.example.di_android2.storage.Storage
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.IsNot.not
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class UserManagerTest {

    lateinit var storage:Storage
    lateinit var userManager: UserManager


    @Before
    fun setUp() {
        storage=FakeStorage()
        var  userComponentFactory: UserComponent.Factory= mock(UserComponent.Factory::class.java)
        var usercomponent:UserComponent =mock(UserComponent::class.java)

        `when`(userComponentFactory.create()).thenReturn(usercomponent)

        userManager= UserManager(storage,userComponentFactory)
    }

        @Test
      fun `username Returns what is in storage`(){
          assertEquals("",userManager.username)

            userManager.registerUser("UserName","Password")

            assertEquals(userManager.username,"UserName")
      }

    @Test
    fun `IsUserRegistered behaves as expected`() {

        assertFalse(userManager.isUserRegistered())

           userManager.registerUser("UserName","Password")

          assertTrue(userManager.isUserRegistered())
//          assertThat(userManager.isUserRegistered(), `is`(equals(true)))
    }


    @Test
    fun `is User LoggedIn`(){
        assertFalse(userManager.isUserLoggedIn())

        userManager.registerUser("Username","Password")

        assertTrue(userManager.isUserLoggedIn())
    }


    @Test
    fun `Register user adds username and password to the storage`() {
        assertFalse(userManager.isUserRegistered())
        assertFalse(userManager.isUserLoggedIn())

        userManager.registerUser("username", "password")

        assertTrue(userManager.isUserRegistered())
        assertTrue(userManager.isUserLoggedIn())
        assertEquals("username", storage.getString("registered_user"))
        assertEquals("password", storage.getString("usernamepassword"))
    }

    @Test
    fun `Login succeeds when username is registered and password is correct`() {
        userManager.registerUser("username", "password")
        userManager.logout()

        assertTrue(userManager.loginUser("username", "password"))
        assertTrue(userManager.isUserLoggedIn())
    }

    @Test
    fun `Login fails when username is not registered`() {
        userManager.registerUser("username", "password")
        userManager.logout()

        assertFalse(userManager.loginUser("username2", "password"))
        assertFalse(userManager.isUserLoggedIn())
    }

    @Test
    fun `Login fails when username is registered but password is incorrect`() {
        userManager.registerUser("username", "password")
        userManager.logout()

        assertFalse(userManager.loginUser("username", "password2"))
        assertFalse(userManager.isUserLoggedIn())
    }

    @Test
    fun `Unregister behaves as expected`() {
        userManager.registerUser("username", "password")
        assertTrue(userManager.isUserLoggedIn())

        userManager.unregister()
        assertFalse(userManager.isUserLoggedIn())
        assertFalse(userManager.isUserRegistered())
    }
}