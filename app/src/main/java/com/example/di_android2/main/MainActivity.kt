package com.example.di_android2.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.di_android2.MyApplication
import com.example.di_android2.R
import com.example.di_android2.login.LoginActivity
import com.example.di_android2.registration.RegistrationActivity
import com.example.di_android2.settings.SettingsActivity
import com.example.di_android2.user.UserManager
import com.google.gson.Gson
import javax.inject.Inject


/**
 * If the User is not registered, RegistrationActivity will be launched,
 * If the User is not logged in, LoginActivity will be launched,
 * else carry on with MainActivity
 */
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var userManager: UserManager


    override fun onCreate(savedInstanceState: Bundle?) {

//        (application as MyApplication).appComponent.userComponent().create().inject(this)


        super.onCreate(savedInstanceState)

//        Log.i("!userManager.isUserLoggedIn()", Gson().toJson(!userManager.isUserLoggedIn()))
//        Log.e("userManager.isUserLoggedIn()",(userManager.isUserLoggedIn()).toString())
//        Log.e("MainActivity  userDataRepository",((((application as MyApplication).userManager).userDataRepository) ==null).toString())

        if(!userManager.isUserLoggedIn()) {
//            Log.i("!userManager.isUserLoggedIn()", Gson().toJson(!userManager.isUserLoggedIn()))

              if (!userManager.isUserRegistered()){
//                  Log.i("Main Activity ", "Here if !userManager.isUserLoggedIn()")
//                  Log.i("Main Activity userManager", Gson().toJson(userManager.userDataRepository))

                  var intent  = Intent(this,RegistrationActivity::class.java)
                         startActivity(intent)
                         finish()  //if finish is not called the onresume() method will be called

              }else{

                  startActivity(Intent(this, LoginActivity::class.java))
                  finish()

              }

        }else {
            Log.i("Main Activity ", "Here else of !userManager.isUserLoggedIn()")

            setContentView(R.layout.activity_main)
//            Log.i("userManager", Gson().toJson(userManager.userDataRepository))


//            mainViewModel = MainViewModel(userManager.userDataRepository!!)
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
        findViewById<TextView>(R.id.hello).text = mainViewModel.welcomeText
        findViewById<Button>(R.id.settings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}