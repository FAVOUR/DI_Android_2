package com.example.di_android2.di

import android.content.Context
import com.example.di_android2.registration.RegistrationActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [StorageModule::class])
interface AppComponent {

  //classes that can be injected by this component
    fun inject(regestrationActivity:RegistrationActivity)

      @Component.Factory
      interface Factory {
        fun create(@BindsInstance context: Context):AppComponent
      }
}