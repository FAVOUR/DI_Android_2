package com.example.di_android2.main

import com.example.di_android2.user.UserDataRepository

class MainViewModel(private val userDataRepository: UserDataRepository) {


    val welcomeText: String
        get() = "Hello ${userDataRepository.username}!"

    val notificationsText: String
        get() = "You have ${userDataRepository.unreadNotifications} unread notifications"

}