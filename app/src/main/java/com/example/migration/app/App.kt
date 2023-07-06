package com.example.migration.app

import android.app.Application
import com.example.migration.di.AppComponent
import com.example.migration.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }
}