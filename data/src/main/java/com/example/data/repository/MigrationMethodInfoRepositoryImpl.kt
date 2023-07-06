package com.example.data.repository

import com.example.data.models.*
import com.example.data.storage.MethodInfoStorage
import com.example.domain.models.MigrationMethodInfo
import com.example.domain.repository.MigrationMethodInfoRepository

class MigrationMethodInfoRepositoryImpl(private val methodInfoStorage: MethodInfoStorage) : MigrationMethodInfoRepository {

    override suspend fun getInfo(path: String): List<MigrationMethodInfo> {
        return mapToDomain(methodInfoStorage.getInfo(path))
    }

    private fun mapToDomain(dataMigrationMethodInfo: List<DataMigrationMethodInfo>): List<MigrationMethodInfo> {
        val result = mutableListOf<MigrationMethodInfo>()

        dataMigrationMethodInfo.forEach { item ->
            when (item) {
                is Title -> result.add(com.example.domain.models.Title(item.text?:""))
                is Text -> result.add(com.example.domain.models.Text(item.text?:""))
                is Image -> result.add(com.example.domain.models.Image(item.imagePath?:"", item.text?:""))
                is BulletList -> item.text?.let {result.add(com.example.domain.models.BulletList(it.split(" ")))}
            }
        }

        return result
    }
}