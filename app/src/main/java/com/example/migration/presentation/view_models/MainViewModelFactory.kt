package com.example.migration.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.migration.domain.usecase.LoadListOfCountriesUseCase

class MainViewModelFactory(
    val loadListOfCountriesUseCase: LoadListOfCountriesUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            loadListOfCountriesUseCase
        ) as T
    }
}