package com.migration.data.storage

import com.example.data.models.DataCountry

interface CountryStorage {

    suspend fun getList() : List<DataCountry>

}