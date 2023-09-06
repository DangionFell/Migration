package com.example.domain.repository

import com.example.domain.models.MigrationMethod

interface MigrationMethodRepository {

    suspend fun getMethodList(path: String) : List<MigrationMethod>

}