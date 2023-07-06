package com.example.migration.presentation.main_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Country
import com.example.domain.usecase.LoadListOfCountriesUseCase

class MainViewModel (
    private val loadListOfCountriesUseCase: LoadListOfCountriesUseCase
) : ViewModel() {

    val countryList = MutableLiveData<List<Country>>()

    suspend fun loadData() {
        countryList.value = loadListOfCountriesUseCase.execute()
    }

}