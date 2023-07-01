package com.example.migration.di

import com.example.domain.repository.MethodRepository
import com.example.domain.usecase.LoadListOfMethodsUseCase
import com.example.domain.repository.CountryRepository
import com.example.domain.usecase.LoadListOfCountriesUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideLoadListOfCountriesUseCase(countryRepository: CountryRepository) : LoadListOfCountriesUseCase {
        return LoadListOfCountriesUseCase(countryRepository)
    }

    @Provides
    fun provideLoadListOfMethodsUseCase(methodRepository: MethodRepository) : LoadListOfMethodsUseCase {
        return LoadListOfMethodsUseCase(methodRepository)
    }
}