package com.example.data.storage

import com.example.data.models.DataMethod

interface MethodStorage {

    suspend fun getMethodList(path: String): List<DataMethod>

}