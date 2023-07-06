package com.example.migration.presentation.country_screen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.migration.R
import com.example.domain.models.Country

private const val ARG_COUNTRY = "country"

class CountryActivity : AppCompatActivity() {

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        val country = intent.getSerializableExtra(ARG_COUNTRY) as Country

        supportFragmentManager.beginTransaction().replace(
            R.id.frame,
            CountryScreenFragment.newInstance(country)
        ).commit()
    }
}