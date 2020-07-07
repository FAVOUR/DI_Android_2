package com.example.di_android2

import android.app.Application
import com.example.di_android2.di.AppComponent
import com.example.di_android2.di.DaggerAppComponent
import com.example.di_android2.storage.SharedPreference
import com.example.di_android2.user.UserManager

open class MyApplication :Application(){

//   open val userManager by lazy {
//          UserManager(SharedPreference(applicationContext))
//   }

      val  appComponent by lazy {
          initializeComponent()
    }

    open fun initializeComponent ():AppComponent{
        return  DaggerAppComponent.factory().create(this)
    }





}