package com.example.di_android2.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.di_android2.user.UserManager

/**
 * LoginViewModel is the ViewModel that [LoginActivity] uses to
 * obtain information of what to show on the screen and handle complex logic.
 */

class LoginViewModel(private val userManager: UserManager){

    private val _loginState = MutableLiveData<LoginViewState>()
    val loginState:LiveData<LoginViewState>
        get() = _loginState

    fun login(userName: String, password: String ){
        if(userManager.loginUser(userName,password)){
            _loginState.value = LoginSuccess
        }else{
            _loginState.value =LoginError
        }

    }

    fun unRegister(){
        userManager.unregister()
    }

    fun getUserName(): String =userManager.username
}