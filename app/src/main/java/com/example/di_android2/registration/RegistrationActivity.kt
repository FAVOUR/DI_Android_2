package com.example.di_android2.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.di_android2.MyApplication
import com.example.di_android2.R
import com.example.di_android2.di.subcomponents.registration_sub_component.RegistrationSubComponent
import com.example.di_android2.main.MainActivity
import com.example.di_android2.registration.enterDetails.EnterDetailsFragment
import com.example.di_android2.registration.termsandcondition.TermsAndConditionsFragment
import javax.inject.Inject

class RegistrationActivity : AppCompatActivity() {

      @Inject
      lateinit var registrationViewModel: RegistrationViewModel

    lateinit var registrationComponent : RegistrationSubComponent

    override fun onCreate(savedInstanceState: Bundle?) {


        (application as MyApplication).appComponent.registrationComponent().create().inject(this)


        // Creates an instance of Registration component by grabbing the factory from the app graph
        registrationComponent = (application as MyApplication).appComponent.registrationComponent().create()
        // Injects this activity to the just created registration component
        registrationComponent.inject(this)

        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_registration)

         supportFragmentManager.beginTransaction()
             .add(R.id.fragment_holder,EnterDetailsFragment() )
             .commit()


    }

    fun onDetailsEntered(){
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




    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStack()
        }else{
            super.onBackPressed()
        }
    }
}