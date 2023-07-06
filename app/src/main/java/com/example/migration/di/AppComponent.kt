package com.example.migration.di

import com.example.migration.presentation.country_screen.CountryScreenFragment
import com.example.migration.presentation.main_screen.MainScreenFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainScreenFragment: MainScreenFragment)
    fun inject(countryScreenFragment: CountryScreenFragment)
}