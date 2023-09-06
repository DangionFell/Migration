package com.example.migration.presentation.getconsultationscreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.ConsultationRequest
import com.example.domain.usecase.SaveConsultationRequestUseCase

class GetConsultationScreenViewModel (
    private val saveConsultationRequestUseCase: SaveConsultationRequestUseCase
): ViewModel() {

    suspend fun saveRequest(consultationRequest: ConsultationRequest) {
        saveConsultationRequestUseCase.execute(consultationRequest)
    }

}