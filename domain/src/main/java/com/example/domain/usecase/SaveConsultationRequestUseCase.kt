package com.example.domain.usecase

import com.example.domain.models.ConsultationRequest
import com.example.domain.repository.ConsultationRequestRepository

class SaveConsultationRequestUseCase(private val consultationRequestRepository: ConsultationRequestRepository) {

    suspend fun execute(consultationRequest: ConsultationRequest) {
        return consultationRequestRepository.saveRequest(consultationRequest)
    }
}