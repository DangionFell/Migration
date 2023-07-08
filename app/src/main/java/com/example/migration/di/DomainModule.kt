package com.example.migration.di

import com.example.domain.repository.*
import com.example.domain.usecase.*
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

    @Provides
    fun provideSaveConsultationRequestUseCase(consultationRequestRepository: ConsultationRequestRepository) : SaveConsultationRequestUseCase {
        return SaveConsultationRequestUseCase(consultationRequestRepository)
    }
}