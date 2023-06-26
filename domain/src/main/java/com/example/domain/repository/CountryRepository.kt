package com.migration.domain.repository

import com.migration.domain.models.Country

interface CountryRepository {

    suspend fun getCountryList(): List<Country>

}