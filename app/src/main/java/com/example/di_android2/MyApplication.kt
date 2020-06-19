package com.example.di_android2

import android.app.Application
import com.example.di_android2.storage.SharedPreference
import com.example.di_android2.user.UserManager

class MyApplication :Application(){

   val userManager by lazy {
          UserManager(SharedPreference(applicationContext))
   }


}