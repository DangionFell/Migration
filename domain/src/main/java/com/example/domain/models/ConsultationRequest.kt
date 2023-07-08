package com.example.domain.models

data class ConsultationRequest(
    val name : String,
    val phone: String,
    val email: String,
    val question: String?,
    val country: String,
    val migrationMethod: String,
    val data: String
)
