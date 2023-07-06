package com.example.migration.presentation.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.LoadListOfCountriesUseCase


class MainViewModelFactory (
    private val loadListOfCountriesUseCase: LoadListOfCountriesUseCase
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            loadListOfCountriesUseCase
        ) as T
    }
}