package com.example.di_android2.di.subcomponents.login

import com.example.di_android2.login.LoginActivity
import dagger.Subcomponent

@Subcomponent
interface LoginComponent {


    @Subcomponent.Factory
    interface  Factory {
        fun  create():LoginComponent
    }

     fun inject(loginActivity:LoginActivity)
}