package com.example.di_android2.di.subcomponents.user

import com.example.di_android2.di.annotation_processors.LoginScope
import com.example.di_android2.main.MainActivity
import com.example.di_android2.settings.SettingsActivity
import dagger.Subcomponent

@LoginScope
@Subcomponent
interface UserComponent {


    @Subcomponent.Factory
      interface  Factory{

        fun create():UserComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(settingsActivity: SettingsActivity)

}