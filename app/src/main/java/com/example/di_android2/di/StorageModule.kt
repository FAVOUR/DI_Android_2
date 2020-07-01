package com.example.di_android2.di

import com.example.di_android2.storage.SharedPreference
import com.example.di_android2.storage.Storage
import dagger.Binds
import dagger.Module

@Module
 abstract  class StorageModule {

    @Binds
    abstract  fun provideStorage(sharedPreference: SharedPreference):Storage
}