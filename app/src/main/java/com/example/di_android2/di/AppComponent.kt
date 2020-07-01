package com.example.di_android2.di

import com.example.di_android2.registration.RegistrationActivity
import dagger.Component

@Component(modules = [StorageModule::class])
interface AppComponent {
  //classes that can be injected by this component
    fun inject(regestrationActivity:RegistrationActivity)
}