package com.example.di_android2.registration.termsandcondition

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.di_android2.MyApplication
import com.example.di_android2.R
import com.example.di_android2.di.subcomponents.registration_sub_component.RegistrationSubComponent
import com.example.di_android2.registration.RegistrationActivity
import com.example.di_android2.registration.RegistrationViewModel
import javax.inject.Inject

class TermsAndConditionsFragment : Fragment() {

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false)



//        registrationViewModel = (activity as RegistrationActivity).registrationViewModel

        view.findViewById<Button>(R.id.next).setOnClickListener {
            registrationViewModel.acceptTC()
            (activity as RegistrationActivity).onTermsAndConditionAccepted()
        }

        return view
    }

    lateinit var registrationComponent : RegistrationSubComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.registrationComponent().create()
            .inject(
            this
        )

        (activity as RegistrationActivity).registrationComponent.inject(termsAndConditionsFragment = this)
    }


}