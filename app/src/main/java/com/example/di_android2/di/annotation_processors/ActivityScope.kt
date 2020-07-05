package com.example.di_android2.di.annotation_processors

import javax.inject.Scope
import javax.inject.Singleton

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation  class ActivityScope {
}