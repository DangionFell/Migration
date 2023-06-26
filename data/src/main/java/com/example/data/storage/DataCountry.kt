package com.migration.data.storage

import java.io.Serializable

data class DataCountry(
    val name: String? = null,
    val migration_methods: String? = null,
    val backUrl: String? = null,
    val flagUrl: String? = null,
    val methods_path: String? = null
) : Serializable
