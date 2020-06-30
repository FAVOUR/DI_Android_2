package com.example.di_android2.registration.enterDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

private const val MAX_LENGTH = 5


class EnterDetailsViewmodel {

    private val  _enterDetailsState = MutableLiveData<EnterDetailsViewState>()

    val enterDetailsState: LiveData<EnterDetailsViewState>
        get() = _enterDetailsState


    fun valideteInput(userName:String, password:String){
        when{
            userName.length < MAX_LENGTH -> _enterDetailsState.value=
                EnterDetailsError("Username has to be longer then 4 characters")
              password.length < MAX_LENGTH -> _enterDetailsState.value=
                  EnterDetailsError("Password has to be longer then 4 characters")

            else ->_enterDetailsState.value =EnterDetailsSuccess
        }
    }
}