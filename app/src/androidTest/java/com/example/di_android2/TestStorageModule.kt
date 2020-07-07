package com.example.di_android2

import com.example.di_android2.storage.FakeStorage
import com.example.di_android2.storage.Storage
import dagger.Binds
import dagger.Module


@Module
abstract class TestStorageModule {

    @Binds
    abstract  fun provideStorage(fakeStorage: FakeStorage): Storage
}