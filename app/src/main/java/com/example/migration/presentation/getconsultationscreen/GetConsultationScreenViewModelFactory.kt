package com.example.migration.presentation.getconsultationscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.SaveConsultationRequestUseCase

class GetConsultationScreenViewModelFactory (
    private val saveConsultationRequestUseCase: SaveConsultationRequestUseCase
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GetConsultationScreenViewModel(
            saveConsultationRequestUseCase
        ) as T
    }
}
