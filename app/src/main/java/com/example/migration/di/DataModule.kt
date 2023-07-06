package com.example.migration.di

import com.example.data.repository.MigrationMethodRepositoryImpl
import com.example.domain.repository.MigrationMethodRepository
import com.example.data.repository.CountryRepositoryImpl
import com.example.data.repository.MigrationMethodInfoRepositoryImpl
import com.example.data.storage.*
import com.example.domain.repository.CountryRepository
import com.example.domain.repository.MigrationMethodInfoRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCountryStorage() : CountryStorage {
        return FirebaseCountryStorage()
    }

    @Provides
    fun provideCountryRepository(countryStorage: CountryStorage) : CountryRepository {
        return CountryRepositoryImpl(countryStorage)
    }

    @Provides
    fun provideMethodStorage(): MethodStorage {
        return FirebaseMethodStorage()
    }

    @Provides
    fun provideMethodRepository(methodStorage: MethodStorage) : MigrationMethodRepository {
        return MigrationMethodRepositoryImpl(methodStorage)
    }

    @Provides
    fun provideMethodInfoStorage(): MethodInfoStorage {
        return FirebaseMethodInfoStorage()
    }

    @Provides
    fun provideMethodInfoRepository(methodInfoStorage: MethodInfoStorage) : MigrationMethodInfoRepository {
        return MigrationMethodInfoRepositoryImpl(methodInfoStorage)
    }
}