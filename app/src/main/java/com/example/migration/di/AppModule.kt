package com.example.migration.di

import com.example.domain.usecase.LoadListOfCountriesUseCase
import com.example.domain.usecase.SaveConsultationRequestUseCase
import com.example.migration.presentation.getconsultationscreen.GetConsultationScreenViewModelFactory
import com.example.migration.presentation.mainscreen.MainViewModelFactory
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

    @Provides
    fun provideGetConsultationScreenViewModelFactory (
        saveConsultationRequestUseCase: SaveConsultationRequestUseCase
    ) : GetConsultationScreenViewModelFactory {
        return GetConsultationScreenViewModelFactory(saveConsultationRequestUseCase)
    }
}