package com.example.migration.presentation.countryscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Country
import com.example.domain.models.SecondScreenItem
import com.example.migration.presentation.countryscreen.models.CountryHeader
import com.example.domain.usecase.LoadListOfMigrationMethodsUseCase

class MethodsScreenViewModel (
    private val loadListOfMigrationMethodsUseCase: LoadListOfMigrationMethodsUseCase,
    private val country : Country
): ViewModel() {

    val migrationMethodList = MutableLiveData<List<SecondScreenItem>>()

    suspend fun loadData() {
        val res = mutableListOf<SecondScreenItem>(CountryHeader(country.name, country.backUrl, country.flagUrl))
        res.addAll(loadListOfMigrationMethodsUseCase.execute(country.methodsPath))

        migrationMethodList.value = res
    }
}