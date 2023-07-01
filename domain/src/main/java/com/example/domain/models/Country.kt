package com.example.domain.models

data class Country (
    val name: String,
    val migrationMethods: String,
    val backUrl: String,
    val flagUrl: String,
    val methodsPath: String
) : java.io.Serializable

