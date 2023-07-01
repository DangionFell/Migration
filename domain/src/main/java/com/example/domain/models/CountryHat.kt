package com.example.domain.models

open class SecondScreenItem

data class CountryHat (
    val name: String,
    val backUrl: String,
    val flagUrl: String
) : SecondScreenItem()
