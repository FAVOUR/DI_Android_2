package com.example.di_android2.di

import android.content.Context
import com.example.di_android2.di.subcomponents.registration_sub_component.RegistrationSubComponent
import com.example.di_android2.di.subcomponents.registration_sub_component.module.AppSubComponent
import com.example.di_android2.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class,AppSubComponent::class])
interface AppComponent {

  //classes that can be injected by this component

    fun inject(mainActivity:MainActivity)

      @Component.Factory
      interface Factory {
        fun create(@BindsInstance context: Context):AppComponent
      }

      fun create():RegistrationSubComponent.Factory
}