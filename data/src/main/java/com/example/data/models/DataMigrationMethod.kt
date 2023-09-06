package com.example.data.models

import java.io.Serializable

data class DataMigrationMethod(
    val title: String? = null,
    val text: String? = null,
    val methodInfoPath: String? = null
) : Serializable
