package com.migration.data.storage

interface CountryStorage {

    suspend fun getList() : List<DataCountry>

}