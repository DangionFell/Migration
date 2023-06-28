package com.example.data.repository

import com.example.data.models.DataMethod
import com.example.data.storage.MethodStorage
import com.example.domain.models.Method
import com.example.domain.repository.MethodRepository

class MethodRepositoryImpl(private val methodStorage: MethodStorage) : MethodRepository {

    override suspend fun getMethodList(path: String): List<Method> {
        return mapToDomain(methodStorage.getMethodList(path))
    }

    private fun mapToDomain(dataMethod: List<DataMethod>): List<Method> {
        val result = mutableListOf<Method>()

        dataMethod.forEach {
            result.add(
                Method(
                    it.title?: "",
                    it.text?: "",
                )
            )
        }

        return result
    }
}