package com.example.di_android2.settings

import androidx.lifecycle.ViewModel
import com.example.di_android2.user.UserDataRepository
import com.example.di_android2.user.UserManager
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class SettingViewmodelTest{

    lateinit var userManager: UserManager

    lateinit var userDataRepository: UserDataRepository
    lateinit var viewmodel: SettingViewmodel


    @Before
    fun setup(){
        userDataRepository = mock(UserDataRepository::class.java)
        userManager = mock(UserManager::class.java)

        viewmodel= SettingViewmodel(userDataRepository,userManager)
    }

    @Test
    fun `refresh Notification Works As Expected`(){
        viewmodel.refreshNotification()
//
        verify(userDataRepository).refreshUnreadNotifications()

        `when`(viewmodel.userDataRepository.unreadNotifications).thenReturn(3)

        assertThat(viewmodel.userDataRepository.unreadNotifications,`is`( equalTo(3)))


    }


    @Test
    fun `Logout works as expected`() {
        viewmodel.logout()

        verify(userManager).logout()
    }

}