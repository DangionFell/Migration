package com.example.domain.usecase

import com.example.domain.models.MigrationMethod
import com.example.domain.repository.MigrationMethodRepository

class LoadListOfMigrationMethodsUseCase(private val migrationMethodRepository: MigrationMethodRepository) {

    suspend fun execute(path: String) : List<MigrationMethod> {
        return migrationMethodRepository.getMethodList(path)
    }

}