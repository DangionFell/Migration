package com.migration.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.migration.domain.models.Country
import com.migration.domain.usecase.LoadListOfCountriesUseCase

class MainViewModel(
    private val loadListOfCountriesUseCase: LoadListOfCountriesUseCase
) : ViewModel() {

    val countryList = MutableLiveData<List<Country>>()

    suspend fun rcLoad() {
        countryList.value = loadListOfCountriesUseCase.execute()
    }

}