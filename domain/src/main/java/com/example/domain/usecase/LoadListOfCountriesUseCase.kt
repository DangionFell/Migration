package com.example.domain.usecase

import com.example.domain.models.Country
import com.example.domain.repository.CountryRepository

class LoadListOfCountriesUseCase(private val countryRepository: CountryRepository) {

    suspend fun execute(): List<Country> {
        return countryRepository.getCountryList()
    }

}