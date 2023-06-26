package com.migration.domain.usecase

import com.migration.domain.models.Country
import com.migration.domain.repository.CountryRepository

class LoadListOfCountriesUseCase(private val countryRepository: CountryRepository) {

    suspend fun execute(): List<Country> {
        return countryRepository.getCountryList()
    }

}