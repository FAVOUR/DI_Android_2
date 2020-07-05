package com.example.di_android2.di.subcomponent_module

import com.example.di_android2.di.subcomponents.login.LoginComponent
import com.example.di_android2.di.subcomponents.registration_sub_component.RegistrationSubComponent
import dagger.Module


@Module(subcomponents = [RegistrationSubComponent::class, LoginComponent::class])
class AppSubComponent {
}