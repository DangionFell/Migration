package com.example.data.models

import java.io.Serializable

data class DataCountry(
    val name: String? = null,
    val migrationMethods: String? = null,
    val backUrl: String? = null,
    val flagUrl: String? = null,
    val methodsPath: String? = null
) : Serializable
