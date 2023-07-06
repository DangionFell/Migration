package com.example.migration.presentation.country_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.models.Country
import com.example.domain.usecase.LoadListOfMethodsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

private const val ARG_COUNTRY = "country"


class MethodsScreenViewModelFactory @AssistedInject constructor (
    private val loadListOfMethodsUseCase: LoadListOfMethodsUseCase,
    @Assisted(ARG_COUNTRY) private val country : Country
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MethodsScreenViewModel(
            loadListOfMethodsUseCase,
            country
        ) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted(ARG_COUNTRY) country : Country) : MethodsScreenViewModelFactory
    }
}