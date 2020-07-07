package com.example.di_android2

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class MyCustomTestRunner :AndroidJUnitRunner(){

    override fun newApplication(
        cl: ClassLoader?, className: String?, context: Context?): Application {

        print("MyTestApplication::class.java.simpleName ${MyTestApplication::class.java.simpleName}")
        print("MyTestApplication::class.java.canonicalName ${MyTestApplication::class.java.canonicalName}")
        print("MyTestApplication::class.simpleName ${MyTestApplication::class.simpleName}")
        print("MyTestApplication::class.qualifiedName ${MyTestApplication::class.qualifiedName}")

        return super.newApplication(cl, MyTestApplication::class.java.simpleName, context)
    }
}