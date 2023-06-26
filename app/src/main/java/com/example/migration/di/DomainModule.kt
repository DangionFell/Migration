package com.migration.di

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
}