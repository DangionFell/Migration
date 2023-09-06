package com.example.data.storage

import com.example.data.models.DataConsultationRequest

interface ConsultationRequestStorage {
    suspend fun saveRequest(dataConsultationRequest: DataConsultationRequest)

}