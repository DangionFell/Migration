package com.example.domain.usecase

import com.example.domain.models.MigrationMethod
import com.example.domain.repository.MethodRepository

class LoadListOfMethodsUseCase(private val methodRepository: MethodRepository) {

    suspend fun execute(path: String) : List<MigrationMethod> {
        return methodRepository.getMethodList(path)
    }

}