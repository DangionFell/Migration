package com.example.data.repository

import com.example.data.models.DataMigrationMethod
import com.example.data.storage.MethodStorage
import com.example.domain.models.MigrationMethod
import com.example.domain.repository.MigrationMethodRepository

class MigrationMethodRepositoryImpl(private val methodStorage: MethodStorage) : MigrationMethodRepository {

    override suspend fun getMethodList(path: String): List<MigrationMethod> {
        return mapToDomain(methodStorage.getMethodList(path))
    }

    private fun mapToDomain(dataMigrationMethod: List<DataMigrationMethod>): List<MigrationMethod> {
        val result = mutableListOf<MigrationMethod>()

        dataMigrationMethod.forEach {
            result.add(
                MigrationMethod(
                    it.title?: "",
                    it.text?: "",
                    it.methodInfoPath?: ""
                )
            )
        }

        return result
    }
}