package com.example.domain.usecase

import com.example.domain.models.Method
import com.example.domain.repository.MethodRepository

class LoadListOfMethodsUseCase(private val methodRepository: MethodRepository) {

    suspend fun execute(path: String) : List<Method>{
        return methodRepository.getMethodList(path)
    }

}