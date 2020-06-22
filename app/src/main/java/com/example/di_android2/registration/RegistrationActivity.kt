package com.example.di_android2.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.di_android2.MyApplication
import com.example.di_android2.R
import com.google.gson.Gson

class RegistrationActivity : AppCompatActivity() {

     lateinit var registretionViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registretionViewModel= RegistrationViewModel((application as MyApplication).userManager)


    }
}