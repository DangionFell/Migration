package com.example.data.storage

import com.example.data.models.DataMigrationMethod

interface MethodStorage {

    suspend fun getMethodList(path: String): List<DataMigrationMethod>

}