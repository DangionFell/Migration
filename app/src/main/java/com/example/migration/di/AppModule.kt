package com.migration.di

import com.migration.domain.usecase.LoadListOfCountriesUseCase
import com.migration.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideMainViewModelFactory(
        loadListOfCountriesUseCase: LoadListOfCountriesUseCase
    ) : MainViewModelFactory {
        return MainViewModelFactory(loadListOfCountriesUseCase)
    }
}