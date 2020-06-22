package com.example.di_android2.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.di_android2.MyApplication
import com.example.di_android2.R
import com.example.di_android2.main.MainActivity
import com.example.di_android2.registration.enterDetails.EnterDetailsFragment
import com.example.di_android2.registration.termsandcondition.TermsAndConditionsFragment

class RegistrationActivity : AppCompatActivity() {

     private lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registrationViewModel= RegistrationViewModel((application as MyApplication).userManager)

         supportFragmentManager.beginTransaction()
             .add(R.id.fragment_holder,EnterDetailsFragment() )
             .commit()


        fun detailedFragment(){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_holder,TermsAndConditionsFragment())
                .addToBackStack(TermsAndConditionsFragment()::class.java.simpleName)
                .commit()
        }


        fun onTermsAndConditionAccepted(){
            registrationViewModel.registerUser()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }



    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStack()
        }else{
            super.onBackPressed()
        }
    }
}