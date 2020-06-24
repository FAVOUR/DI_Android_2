package com.example.di_android2.registration

import com.example.di_android2.storage.FakeStorage
import com.example.di_android2.user.UserManager
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class RegistrationViewModelTest{

    lateinit var viewModel:RegistrationViewModel
    lateinit var userManager: UserManager

    @Before
    fun setup(){
        userManager= mock(UserManager::class.java)
        viewModel = RegistrationViewModel(userManager)
    }

    @Test
    fun `registerUser calls userManager`(){
        viewModel.updateUser("username","password")
        viewModel.acceptTC()
        viewModel.registerUser()

       verify(userManager).registerUser("username","password")


    }
}