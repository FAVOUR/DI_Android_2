package com.example.di_android2

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.test.runner.AndroidJUnitRunner

class MyCustomTestRunner :AndroidJUnitRunner(){

    override fun newApplication(
        cl: ClassLoader?, className: String?, context: Context?): Application {

        Log.e("MyTestApplication::class.java.name ","${MyTestApplication::class.java.name}")
        Log.e("MyTestApplication::class.java.canonicalName"," ${MyTestApplication::class.java.canonicalName}")
        Log.e("MyTestApplication::class.simpleName ","${MyTestApplication::class.simpleName}")
        Log.e("MyTestApplication::class.qualifiedName"," ${MyTestApplication::class.qualifiedName}")

        return super.newApplication(cl, MyTestApplication::class.java.name, context)
    }
}