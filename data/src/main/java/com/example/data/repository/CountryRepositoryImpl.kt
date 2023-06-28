package com.migration.data.repository

import com.migration.data.storage.CountryStorage
import com.example.data.models.DataCountry
import com.migration.domain.models.Country
import com.migration.domain.repository.CountryRepository


class CountryRepositoryImpl(private val countryStorage: CountryStorage) : CountryRepository {

    override suspend fun getCountryList(): List<Country> {
        return mapToDomain(countryStorage.getList())
    }

    private fun mapToDomain(dataCountry: List<DataCountry>): List<Country> {
        val result = mutableListOf<Country>()

        dataCountry.forEach {
            result.add(
                Country(
                    it.name?: "",
                    it.migration_methods?: "",
                    it.backUrl?: "",
                    it.flagUrl?: "",
                    it.methods_path?: ""
                )
            )
        }

        return result
    }

}