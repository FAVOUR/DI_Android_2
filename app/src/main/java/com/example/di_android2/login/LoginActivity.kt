package com.example.di_android2.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import com.example.di_android2.MyApplication
import com.example.di_android2.R
import com.example.di_android2.main.MainActivity
import com.example.di_android2.registration.RegistrationActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
     lateinit var loginViewModel: LoginViewModel
    private lateinit var errorTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MyApplication).appComponent.loginComponent().create().inject(this)
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_login)

        //Creates ViewModel and Listeners for loginState LiveData
//        loginViewModel = LoginViewModel((application as MyApplication).userManager)
        loginViewModel.loginState.observe(this, Observer<LoginViewState>{ state ->

            Log.e("Login activity ",Gson().toJson(state))

            when(state){
                is LoginViewState ->{

//                    Log.e("Login activity Success",Gson().toJson(((application as MyApplication).userManager).userDataRepository?.username))
//                    Log.e("LoginActivity  userDataRepository",((((application as MyApplication).userManager).userDataRepository) ==null).toString())
                    Log.e("Login activity Success","Login Success")


                    startActivity(Intent(this , MainActivity::class.java))
                     finish()
                }
                is LoginError -> errorTextView.visibility = View.VISIBLE
            }

        })

        errorTextView = findViewById(R.id.error)
        setupViews()

    }

     private fun setupViews(){

         val usernameEditText = findViewById<EditText>(R.id.username)
         usernameEditText.isEnabled=false
         usernameEditText.setText(loginViewModel.getUserName())

         val passwordEditText = findViewById<EditText>(R.id.password)

         passwordEditText.doOnTextChanged{ _,_,_,_ -> errorTextView.visibility =View.INVISIBLE}

         findViewById<Button>(R.id.login).setOnClickListener {

             loginViewModel.login(usernameEditText.text.toString(),passwordEditText.text.toString())
         }


         findViewById<Button>(R.id.unregister).setOnClickListener {
             loginViewModel.unRegister()
             val intent = Intent(this,RegistrationActivity::class.java)
                intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK
             startActivity(intent)
         }
     }


}

sealed class  LoginViewState
object LoginSuccess:LoginViewState()
object LoginError :LoginViewState()