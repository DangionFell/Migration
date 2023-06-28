package com.example.domain.repository

import com.example.domain.models.Method


interface MethodRepository {

    suspend fun getMethodList(path: String) : List<Method>

}