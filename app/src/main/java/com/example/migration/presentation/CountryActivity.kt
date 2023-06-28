package com.migration.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.migration.R
import com.example.migration.presentation.CountryScreenFragment
import com.migration.domain.models.Country

class CountryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        val country = intent.getSerializableExtra("country") as Country

        supportFragmentManager.beginTransaction().replace(
            R.id.frame,
            CountryScreenFragment.newInstance(country)
        ).commit()
    }
}