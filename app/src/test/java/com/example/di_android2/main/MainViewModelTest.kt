package com.example.di_android2.main

import com.example.di_android2.user.UserDataRepository
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when` as whenever
import org.mockito.Mockito.mock

class MainViewModelTest{

    lateinit  var userDataRepository:UserDataRepository
    lateinit  var mainViewModel: MainViewModel

    @Before
    fun setup(){
        userDataRepository= mock(UserDataRepository::class.java)
        mainViewModel = MainViewModel(userDataRepository)
    }

    @Test
    fun `Welcome test returns the right message `(){

        whenever(userDataRepository.username).thenReturn("username")

        assertThat("Hello username!", `is`(mainViewModel.welcomeText))
    }


@Test
    fun `Notification text returns the right message` (){
    whenever(userDataRepository.unreadNotifications).thenReturn(5)

            assertThat("You have 5 unread notifications", `is`(mainViewModel.notificationsText))
    }



}