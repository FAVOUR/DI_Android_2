package com.example.di_android2.storage

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class FakeStorage :Storage{

   private val map = mutableMapOf<String,String>()

    override fun getString(key: String): String {
        return map[key].orEmpty()
    }

    override fun setString(key: String, value: String) {
        map[key] = value
    }


}