package com.example.domain.usecase

import com.example.domain.models.MigrationMethodInfo
import com.example.domain.repository.MigrationMethodInfoRepository

class LoadMigrationMethodInfoUseCase(private val migrationMethodInfoRepository: MigrationMethodInfoRepository) {

    suspend fun execute(path: String): List<MigrationMethodInfo> {
        return migrationMethodInfoRepository.getInfo(path)
    }

}