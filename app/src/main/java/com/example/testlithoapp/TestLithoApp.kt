package com.example.testlithoapp

import android.app.Application
import com.facebook.soloader.SoLoader

class TestLithoApp: Application() {
    override fun onCreate() {
        super.onCreate()

        SoLoader.init(this, false)
    }
}