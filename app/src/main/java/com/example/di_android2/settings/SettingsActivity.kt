package com.example.di_android2.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.di_android2.MyApplication
import com.example.di_android2.R
import com.example.di_android2.login.LoginActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var  settingsViewmodel: SettingViewmodel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val userManager=(application as MyApplication).userManager

        settingsViewmodel = SettingViewmodel(userManager.userDataRepository!!,userManager)
         setupViews()
    }

    private fun setupViews(){
        findViewById<Button>(R.id.refresh).setOnClickListener {
            settingsViewmodel.refreshNotification()
        }

        findViewById<Button>(R.id.logout).setOnClickListener {
            settingsViewmodel.logout()
            val intent =Intent(this, LoginActivity::class.java)
              intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                              Intent.FLAG_ACTIVITY_CLEAR_TASK or
                              Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}