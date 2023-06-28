package com.migration.di

import com.example.domain.usecase.LoadListOfMethodsUseCase
import com.example.migration.presentation.view_models.MethodsScreenViewModelFactory
import com.migration.domain.usecase.LoadListOfCountriesUseCase
import com.example.migration.presentation.view_models.MainViewModelFactory
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

    @Provides
    fun provideMethodsScreenViewModelFactory(
        loadListOfMethodsUseCase: LoadListOfMethodsUseCase
    ) : MethodsScreenViewModelFactory {
        return MethodsScreenViewModelFactory(loadListOfMethodsUseCase)
    }
}