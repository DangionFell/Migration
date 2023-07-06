package com.example.data.storage

import com.example.data.models.DataMigrationMethodInfo

interface MethodInfoStorage {

    suspend fun getInfo(path: String) : List<DataMigrationMethodInfo>

}