package com.example.migration.di

import com.example.domain.usecase.LoadListOfCountriesUseCase
import com.example.migration.presentation.main_screen.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule() {

    @Provides
    fun provideMainViewModelFactory (
        loadListOfCountriesUseCase: LoadListOfCountriesUseCase
    ) : MainViewModelFactory {
        return MainViewModelFactory(loadListOfCountriesUseCase)
    }
}