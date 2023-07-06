package com.example.domain.repository

import com.example.domain.models.MigrationMethod

interface MethodRepository {

    suspend fun getMethodList(path: String) : List<MigrationMethod>

}