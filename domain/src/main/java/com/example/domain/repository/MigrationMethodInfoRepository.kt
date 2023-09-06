package com.example.domain.repository
import com.example.domain.models.MigrationMethodInfo

interface MigrationMethodInfoRepository {

    suspend fun getInfo(path: String): List<MigrationMethodInfo>

}