package com.example.di_android2.di.subcomponents.registration_sub_component

import com.example.di_android2.registration.RegistrationActivity
import com.example.di_android2.registration.enterDetails.EnterDetailsFragment
import com.example.di_android2.registration.termsandcondition.TermsAndConditionsFragment
import dagger.Subcomponent

@Subcomponent
 interface RegistrationSubComponent {

    @Subcomponent.Factory
    interface Factory{

        fun create ():RegistrationSubComponent
    }

    fun inject(registrationActivity: RegistrationActivity)
    fun inject(enterDetailsActivity: EnterDetailsFragment)
    fun inject(termsAndConditionsFragment: TermsAndConditionsFragment)
}

