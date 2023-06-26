package com.migration.domain.models

data class Country(
    val name: String,
    val migration_methods: String,
    val backUrl: String,
    val flagUrl: String,
    val methods_path: String
) : java.io.Serializable

