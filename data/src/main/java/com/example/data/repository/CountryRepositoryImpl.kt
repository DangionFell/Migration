package com.example.data.repository

import com.example.data.storage.CountryStorage
import com.example.data.models.DataCountry
import com.example.domain.models.Country
import com.example.domain.repository.CountryRepository

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
                    it.migrationMethods?: "",
                    it.backUrl?: "",
                    it.flagUrl?: "",
                    it.methodsPath?: ""
                )
            )
        }

        return result
    }

}