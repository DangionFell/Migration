package com.example.migration.di

import com.example.migration.presentation.countryscreen.CountryScreenFragment
import com.example.migration.presentation.getconsultationscreen.GetConsultationFragment
import com.example.migration.presentation.mainscreen.MainScreenFragment
import com.example.migration.presentation.methodinfoscreen.MethodInfoFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainScreenFragment: MainScreenFragment)
    fun inject(countryScreenFragment: CountryScreenFragment)
    fun inject(methodInfoFragment: MethodInfoFragment)
    fun inject(getConsultationFragment: GetConsultationFragment)
}