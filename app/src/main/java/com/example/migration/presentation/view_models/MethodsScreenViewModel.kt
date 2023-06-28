package com.example.migration.presentation.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Method
import com.example.domain.usecase.LoadListOfMethodsUseCase

class MethodsScreenViewModel(
    private val loadListOfMethodsUseCase: LoadListOfMethodsUseCase
) : ViewModel() {

    val methodList = MutableLiveData<List<Method>>()

    suspend fun rcLoad(path: String) {
        methodList.value = loadListOfMethodsUseCase.execute(path)
    }
}