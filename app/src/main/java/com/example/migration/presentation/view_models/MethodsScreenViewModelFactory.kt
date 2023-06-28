package com.example.migration.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.LoadListOfMethodsUseCase

class MethodsScreenViewModelFactory(
    val loadListOfMethodsUseCase: LoadListOfMethodsUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MethodsScreenViewModel(
            loadListOfMethodsUseCase
        ) as T
    }
}