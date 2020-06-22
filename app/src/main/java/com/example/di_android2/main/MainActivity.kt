package com.example.di_android2.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.di_android2.MyApplication
import com.example.di_android2.R
import com.example.di_android2.registration.RegistrationActivity
import com.google.gson.Gson


private lateinit var mainViewModel: MainViewModel

/**
 * If the User is not registered, RegistrationActivity will be launched,
 * If the User is not logged in, LoginActivity will be launched,
 * else carry on with MainActivity
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userManager = (application as MyApplication).userManager

        if(userManager.isUserLoggedIn()) {

              if (!userManager.isUserRegistered()){

                  var intent  = Intent(this,RegistrationActivity::class.java)
                         startActivity(intent)

              }else{

              }

        }else {
            setContentView(R.layout.activity_main)
            Log.i("userManager", Gson().toJson(userManager.userDataRepository))

            mainViewModel = MainViewModel(userManager.userDataRepository!!)
            setupViews()
        }
    }



    /**
     * Updating unread notifications onResume because they can get updated on SettingsActivity
     */
    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.notifications).text = mainViewModel.notificationsText
    }

    private fun setupViews() {
//        findViewById<TextView>(R.id.hello).text = mainViewModel.welcomeText
        findViewById<Button>(R.id.settings).setOnClickListener {
//            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}