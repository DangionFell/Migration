package com.migration.di

import com.example.migration.presentation.CountryScreenFragment
import com.example.migration.presentation.MainActivity
import com.migration.presentation.CountryActivity
import com.migration.presentation.MainScreenFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainScreenFragment: MainScreenFragment)

    fun inject(countryActivity: CountryActivity)

    fun inject(countryScreenFragment: CountryScreenFragment)
}