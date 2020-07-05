package com.example.di_android2.registration.enterDetails

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import com.example.di_android2.MyApplication
import com.example.di_android2.R
import com.example.di_android2.registration.RegistrationActivity
import com.example.di_android2.registration.RegistrationViewModel
import com.example.di_android2.registration.termsandcondition.TermsAndConditionsFragment
import com.google.gson.Gson
import javax.inject.Inject

class EnterDetailsFragment : Fragment() {

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    @Inject
     lateinit var enterDetailsViewModel: EnterDetailsViewmodel

    private lateinit var errorTextView: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_enter_details, container, false)


//            registrationViewModel= (activity as RegistrationActivity).registrationViewModel

//        enterDetailsViewModel = EnterDetailsViewmodel()


        enterDetailsViewModel.enterDetailsState.observe(this, Observer <EnterDetailsViewState>{state->
                when(state){

                    is EnterDetailsSuccess ->{
                         val username = usernameEditText.text.toString()
                         val password = passwordEditText.text.toString()

                        registrationViewModel.updateUser(username, password)

                        (activity as RegistrationActivity).onDetailsEntered()

                    }
                    is EnterDetailsError ->{
                        errorTextView.text = state.error
                        errorTextView.visibility = View.VISIBLE
                    }
                }
            })

        setupViews(view)

        return view
    }

    private fun setupViews(view: View) {
        errorTextView = view.findViewById(R.id.error)

        usernameEditText = view.findViewById(R.id.username)
        usernameEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        passwordEditText = view.findViewById(R.id.password)
        passwordEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        view.findViewById<Button>(R.id.next).setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            Log.e("password.length ed ",(password.length).toString())
//            Log.e("password.length < MAX_LENGTH ed ",(password.length < MAX_LENGTH).toString())
            enterDetailsViewModel.valideteInput(username, password)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as RegistrationActivity).registrationComponent.inject(enterDetailsActivity = this)

    }


}

sealed class EnterDetailsViewState
object EnterDetailsSuccess : EnterDetailsViewState()
data class EnterDetailsError(val error: String) : EnterDetailsViewState()
