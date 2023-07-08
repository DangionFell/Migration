package com.example.domain.repository

import com.example.domain.models.ConsultationRequest

interface ConsultationRequestRepository {

    suspend fun saveRequest(consultationRequest: ConsultationRequest)
}