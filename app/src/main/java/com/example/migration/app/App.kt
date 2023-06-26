package com.migration.app

import android.app.Application
import com.migration.di.AppComponent
import com.migration.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }
}