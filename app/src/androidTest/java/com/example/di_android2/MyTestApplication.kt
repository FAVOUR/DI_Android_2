package com.example.di_android2

import android.app.Application
import com.example.di_android2.di.AppComponent
import com.example.di_android2.storage.FakeStorage
import com.example.di_android2.user.UserManager

class MyTestApplication  :MyApplication() {

    override fun initializeComponent(): AppComponent {

       return  DaggerTestComponent.create()

              }
}