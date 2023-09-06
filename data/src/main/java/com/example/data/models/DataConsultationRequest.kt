package com.example.data.models

data class DataConsultationRequest (
    val name : String,
    val phone: String,
    val email: String,
    val question: String,
    val country: String,
    val migrationMethod: String,
    val data: String
)