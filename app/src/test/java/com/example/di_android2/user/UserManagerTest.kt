package com.example.di_android2.user

import com.example.di_android2.storage.FakeStorage
import com.example.di_android2.storage.Storage
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.IsNot.not
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class UserManagerTest {

    lateinit var storage:Storage
    lateinit var userManager: UserManager


    @Before
    fun setUp() {
        storage=FakeStorage()
        userManager= UserManager(storage)
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
    fun getUsername() {
    }

    @Test
    fun isUserLoggedIn() {
    }

    @Test
    fun isUserRegistered() {
    }

    @Test
    fun registerUser() {
    }

    @Test
    fun loginUser() {
    }

    @Test
    fun logout() {
    }

    @Test
    fun unregister() {
    }

    @Test
    fun getStorage() {
    }
}