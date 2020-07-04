package com.example.di_android2.di

import android.content.Context
import com.example.di_android2.main.MainActivity
import com.example.di_android2.registration.RegistrationActivity
import com.example.di_android2.registration.enterDetails.EnterDetailsFragment
import com.example.di_android2.registration.termsandcondition.TermsAndConditionsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent {

  //classes that can be injected by this component

    fun inject(mainActivity:MainActivity)

      @Component.Factory
      interface Factory {
        fun create(@BindsInstance context: Context):AppComponent
      }
}