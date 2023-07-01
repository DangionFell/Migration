package com.example.migration.presentation.country_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.SecondScreenItem
import com.example.domain.models.Country
import com.example.domain.models.CountryHat
import com.example.domain.usecase.LoadListOfMethodsUseCase

class MethodsScreenViewModel (
    private val loadListOfMethodsUseCase: LoadListOfMethodsUseCase,
    private val country : Country
) : ViewModel() {

    val migrationMethodList = MutableLiveData<List<SecondScreenItem>>()

    suspend fun loadData() {
        val res = mutableListOf<SecondScreenItem>(CountryHat(country.name, country.backUrl, country.flagUrl))
        res.addAll(loadListOfMethodsUseCase.execute(country.methodsPath))

        migrationMethodList.value = res
    }
}