package com.example.migration.di

import com.example.data.repository.MethodRepositoryImpl
import com.example.data.storage.FirebaseMethodStorage
import com.example.data.storage.MethodStorage
import com.example.domain.repository.MethodRepository
import com.example.data.repository.CountryRepositoryImpl
import com.example.data.storage.CountryStorage
import com.example.data.storage.FirebaseCountryStorage
import com.example.domain.repository.CountryRepository
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
    fun provideMethodRepository(methodStorage: MethodStorage) : MethodRepository {
        return MethodRepositoryImpl(methodStorage)
    }

}