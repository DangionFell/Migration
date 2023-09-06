package com.example.migration.presentation.methodinfoscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.models.MigrationMethod
import com.example.domain.usecase.LoadMigrationMethodInfoUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MethodInfoScreenViewModelFactory @AssistedInject constructor (
    private val loadMigrationMethodInfoUseCase: LoadMigrationMethodInfoUseCase,
    @Assisted(ARG_METHOD) private val method: MigrationMethod
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MethodInfoScreenViewModel(
            loadMigrationMethodInfoUseCase,
            method
        ) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted(ARG_METHOD) method: MigrationMethod): MethodInfoScreenViewModelFactory
    }

    companion object {
        private const val ARG_METHOD = "method"
    }
}