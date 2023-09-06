package com.example.data.repository

import com.example.data.models.DataConsultationRequest
import com.example.data.storage.ConsultationRequestStorage
import com.example.domain.models.ConsultationRequest
import com.example.domain.repository.ConsultationRequestRepository

class ConsultationRequestRepositoryImpl(private val consultationRequestStorage: ConsultationRequestStorage): ConsultationRequestRepository {

    override suspend fun saveRequest(consultationRequest: ConsultationRequest) {
        consultationRequestStorage.saveRequest(mapToData(consultationRequest))
    }

    private fun mapToData(consultationRequest: ConsultationRequest): DataConsultationRequest {
        return DataConsultationRequest(
            consultationRequest.name,
            consultationRequest.phone,
            consultationRequest.email,
            consultationRequest.question?:"",
            consultationRequest.country,
            consultationRequest.migrationMethod,
            consultationRequest.data
        )
    }

}