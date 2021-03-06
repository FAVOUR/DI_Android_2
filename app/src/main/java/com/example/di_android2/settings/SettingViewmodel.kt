package com.example.di_android2.settings

import com.example.di_android2.user.UserDataRepository
import com.example.di_android2.user.UserManager
import javax.inject.Inject

class SettingViewmodel @Inject constructor(val userDataRepository: UserDataRepository,val userManager: UserManager) {

    fun refreshNotification(){
        userDataRepository.refreshUnreadNotifications()
    }

    fun logout(){
        userManager.logout()
    }
}

