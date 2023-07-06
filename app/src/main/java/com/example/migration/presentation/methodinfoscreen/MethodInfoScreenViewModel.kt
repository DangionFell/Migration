package com.example.migration.presentation.methodinfoscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.MigrationMethod
import com.example.domain.models.MigrationMethodInfo
import com.example.domain.usecase.LoadMigrationMethodInfoUseCase
import com.example.migration.presentation.methodinfoscreen.models.Banner

class MethodInfoScreenViewModel (
    private val loadMigrationMethodInfoUseCase: LoadMigrationMethodInfoUseCase,
    private val method: MigrationMethod
): ViewModel() {

    val methodInfo = MutableLiveData<List<MigrationMethodInfo>>()

    suspend fun loadData() {
        val res = mutableListOf<MigrationMethodInfo>()
        res.addAll(loadMigrationMethodInfoUseCase.execute(method.methodInfoPath))

        res.add(Banner(BANNER_TEXT))

        methodInfo.value = res
    }

    companion object {
        private const val BANNER_TEXT = "Получить консультацию"
    }
}