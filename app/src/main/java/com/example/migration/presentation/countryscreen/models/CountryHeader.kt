package com.example.migration.presentation.countryscreen.models

import com.example.domain.models.SecondScreenItem

data class CountryHeader (
    val name: String,
    val backUrl: String,
    val flagUrl: String
) : SecondScreenItem()
