package com.example.di_android2.user

import android.util.Log
import com.example.di_android2.di.subcomponents.user.UserComponent
import com.example.di_android2.storage.Storage
import javax.inject.Inject
import javax.inject.Singleton


private const val REGISTERED_USER = "registered_user"
private const val PASSWORD_SUFFIX = "password"

/**
 * Handles User lifecycle. Manages registrations,
 * logs in and logs out.
 * Knows when the user is logged in.
 */
@Singleton
class UserManager @Inject constructor(private val storage: Storage, private val userComponentFactory: UserComponent.Factory) {

        /**
         *  UserDataRepository is specific to a logged in user. This determines if the user
         *  is logged in or not, when the user logs in, a new instance will be created.
         *  When the user logs out, this will be null.
         */
//        var userDataRepository: UserDataRepository? = null

          var userComponent:UserComponent? = null
             private set

        val username: String
            get() = storage.getString(REGISTERED_USER)

//        fun isUserLoggedIn() = userDataRepository != null
        fun isUserLoggedIn() = userComponent != null

        fun isUserRegistered() = storage.getString(REGISTERED_USER).isNotEmpty()

        fun registerUser(username: String, password: String) {
            storage.setString(REGISTERED_USER, username)
            storage.setString("$username$PASSWORD_SUFFIX", password)
            userJustLoggedIn()
        }

        fun loginUser(username: String, password: String): Boolean {
            val registeredUser = this.username
            if (registeredUser != username) return false

            val registeredPassword = storage.getString("$username$PASSWORD_SUFFIX")
//            Log.e("registeredPassword",registeredPassword)
//            Log.e("password",password)

            if (registeredPassword != password) return false

            userJustLoggedIn()
            return true
        }

        fun logout() {
//            userDataRepository = null
            userComponent = null
        }

        fun unregister() {
            val username = storage.getString(REGISTERED_USER)
            storage.setString(REGISTERED_USER, "")
            storage.setString("$username$PASSWORD_SUFFIX", "")
            logout()
        }

        private fun userJustLoggedIn() {
//            userDataRepository = UserDataRepository(this)
            userComponent = userComponentFactory.create()
        }


    }