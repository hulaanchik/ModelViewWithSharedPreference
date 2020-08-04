package com.example.modelview.user

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.modelview.user.MainApplication.Companion.applicationContext

class MainApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: MainApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        // example: SharedPreferences etc...
        val context: Context = MainApplication.applicationContext()
    }
}