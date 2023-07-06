package com.example.migration.presentation.countryscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.models.Country
import com.example.domain.usecase.LoadListOfMigrationMethodsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MethodsScreenViewModelFactory @AssistedInject constructor (
    private val loadListOfMigrationMethodsUseCase: LoadListOfMigrationMethodsUseCase,
    @Assisted(ARG_COUNTRY) private val country : Country
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MethodsScreenViewModel(
            loadListOfMigrationMethodsUseCase,
            country
        ) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted(ARG_COUNTRY) country : Country) : MethodsScreenViewModelFactory
    }

    companion object {
        private const val ARG_COUNTRY = "country"
    }
}