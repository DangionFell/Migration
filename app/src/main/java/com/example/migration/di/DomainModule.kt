package com.migration.di

import com.example.domain.repository.MethodRepository
import com.example.domain.usecase.LoadListOfMethodsUseCase
import com.migration.domain.repository.CountryRepository
import com.migration.domain.usecase.LoadListOfCountriesUseCase
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