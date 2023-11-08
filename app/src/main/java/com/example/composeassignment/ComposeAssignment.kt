package com.example.composeassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComposeAssignment :Application() {
    override fun onCreate() {
        super.onCreate()
    }
}