package com.example.di_android2.storage

import android.content.Context

class SharedPreference(context:Context):Storage {

    val sharedPreference =  context.getSharedPreferences("Dagger",Context.MODE_PRIVATE)

    override fun getStorage(key: String): String? {
         return sharedPreference.getString(key,"")
    }

    override fun setString(key: String, value: String) {
        with(sharedPreference.edit()){
            putString(key, value)
                .apply()
        }
    }
}