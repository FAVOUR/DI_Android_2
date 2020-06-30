package com.example.di_android2.registration.enterDetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.di_android2.getorAwaitValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EnterDetailsViewmodelTest{
    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: EnterDetailsViewmodel

    @Before
    fun setup() {
        viewModel = EnterDetailsViewmodel()
    }

    @Test
    fun `ValidateInput gives error when username is invalid`() {
        viewModel.valideteInput("user", "password")

        assertTrue(viewModel.enterDetailsState.getorAwaitValue()  is EnterDetailsError)
    }

    @Test
    fun `ValidateInput gives error when password is invalid`() {
        viewModel.valideteInput("username", "pass")

        assertTrue(viewModel.enterDetailsState.getorAwaitValue() is EnterDetailsError)
    }

    @Test
    fun `ValidateInput succeeds when input is valid`() {
        viewModel.valideteInput("username", "password")

        assertTrue(viewModel.enterDetailsState.getorAwaitValue() is EnterDetailsSuccess)
    }
}