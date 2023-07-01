package com.example.domain.repository

import com.example.domain.models.Country

interface CountryRepository {

    suspend fun getCountryList(): List<Country>

}