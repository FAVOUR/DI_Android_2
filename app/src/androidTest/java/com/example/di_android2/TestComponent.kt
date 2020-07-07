package com.example.di_android2

import com.example.di_android2.di.AppComponent
import dagger.Component
import dagger.Module


@Component(modules = [AppComponent::class, TestStorageModule::class])
interface TestComponent :AppComponent {
}