package com.example.migration.presentation.countryscreen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.migration.R
import com.example.domain.models.Country

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

    companion object {
        private const val ARG_COUNTRY = "country"
    }
}