package com.example.di_android2

import com.example.di_android2.di.AppComponent
import com.example.di_android2.di.subcomponent_module.AppSubComponent
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AppSubComponent::class, TestStorageModule::class])
interface TestComponent :AppComponent