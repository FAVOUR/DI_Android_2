package com.example.di_android2.registration

import android.util.Log
import com.example.di_android2.user.UserManager
import com.google.gson.Gson

class RegistrationViewModel(val userManager: UserManager) {

    private var username:String? =null
    private var  password:String? =null
    private var  acceptTC:Boolean? =null


//    init {
//        Log.i("userManager", Gson().toJson(userManager.userDataRepository))
//
//    }
    fun updateUser(username:String,password:String){
        this.username= username
        this.password= password
    }


    fun acceptTC(){
        acceptTC=true
    }


    fun registerUser(){
        assert(username != null)
        assert(password != null)
        assert(acceptTC ==true)

        userManager.registerUser(username = username!!,password = password!!)

    }







}