package com.example.di_android2.main

import android.util.Log
import com.example.di_android2.user.UserDataRepository
import com.google.gson.Gson
import javax.inject.Inject

class MainViewModel @Inject constructor (private val userDataRepository: UserDataRepository) {

//init {
//    Log.i("userManager", Gson().toJson(userDataRepository))
//
//}
    val welcomeText: String
        get() = "Hello ${userDataRepository.username}!"


    val notificationsText: String
        get() = "You have ${userDataRepository.unreadNotifications} unread notifications"

}