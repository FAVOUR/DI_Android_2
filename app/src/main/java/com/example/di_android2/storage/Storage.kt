package com.example.di_android2.storage

interface Storage{

    fun getStorage(key: String): String?
    fun setString(key:String,value:String)
}