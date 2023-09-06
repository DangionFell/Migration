package com.example.domain.models

open class SecondScreenItem

data class MigrationMethod (
    val title: String,
    val text: String,
    val methodInfoPath: String
) : SecondScreenItem(), java.io.Serializable
