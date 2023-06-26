package com.migration.domain.usecase

import com.migration.domain.models.Country

class OpenCountryScreenUseCase {

    fun execute(country: Country): Country {
        return(country)
    }
}