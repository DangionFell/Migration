package com.migration.di

import com.migration.data.repository.CountryRepositoryImpl
import com.migration.data.storage.CountryStorage
import com.migration.data.storage.FirebaseCountryStorage
import com.migration.domain.repository.CountryRepository
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
}