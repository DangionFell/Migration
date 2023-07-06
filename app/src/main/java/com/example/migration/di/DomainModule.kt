package com.example.migration.di

import com.example.domain.repository.MigrationMethodRepository
import com.example.domain.usecase.LoadListOfMigrationMethodsUseCase
import com.example.domain.repository.CountryRepository
import com.example.domain.repository.MigrationMethodInfoRepository
import com.example.domain.usecase.LoadListOfCountriesUseCase
import com.example.domain.usecase.LoadMigrationMethodInfoUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideLoadListOfCountriesUseCase(countryRepository: CountryRepository) : LoadListOfCountriesUseCase {
        return LoadListOfCountriesUseCase(countryRepository)
    }

    @Provides
    fun provideLoadListOfMethodsUseCase(migrationMethodRepository: MigrationMethodRepository) : LoadListOfMigrationMethodsUseCase {
        return LoadListOfMigrationMethodsUseCase(migrationMethodRepository)
    }

    @Provides
    fun provideLoadMigrationMethodInfoUseCase(migrationMethodInfoRepository: MigrationMethodInfoRepository) : LoadMigrationMethodInfoUseCase {
        return LoadMigrationMethodInfoUseCase(migrationMethodInfoRepository)
    }
}