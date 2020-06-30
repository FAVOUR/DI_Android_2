package com.example.di_android2.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.di_android2.getorAwaitValue
import com.example.di_android2.user.UserManager
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*

class LoginViewModelTest{

    lateinit  var userManager:UserManager
    lateinit  var loginViewModel: LoginViewModel

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantTaskExecutor = InstantTaskExecutorRule()



    @Before
    fun setup(){
         userManager = mock(UserManager::class.java)
        loginViewModel = LoginViewModel(userManager = userManager)
    }

    @Test
    fun `get username`(){
        `when`(userManager.username).thenReturn("UserName")

        val username = loginViewModel.getUserName()

        assertThat("UserName", `is`(username))


    }

   @Test
    fun `Login emits success`(){
        `when`(userManager.loginUser(anyString(), anyString())).thenReturn(true)

        loginViewModel.login("UserName","Password")

        assertEquals(    loginViewModel.loginState.getorAwaitValue(), LoginSuccess)

//        val value =  loginViewModel.loginState.getorAwaitValue()
//        assertThat(   value, `is`(LoginSuccess))
    }

       @Test
       fun `Login emits error` (){
          `when`(userManager.loginUser(anyString(),anyString())).thenReturn(false)

           loginViewModel.login("UserName","Password")

//            assertThat(loginViewModel.loginState.getorAwaitValue(),`is`(LoginError))
            assertEquals(loginViewModel.loginState.getorAwaitValue(), (LoginError))
       }
}