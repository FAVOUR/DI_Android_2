package com.example.di_android2.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.di_android2.MyApplication
import com.example.di_android2.R

class SettingsActivity : AppCompatActivity() {

    private lateinit var  settingsViewmodel: SettingViewmodel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings2)

        val userManager=(application as MyApplication).userManager

    }
}