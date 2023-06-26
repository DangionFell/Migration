package com.example.migration.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.migration.R
import com.migration.presentation.MainScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, MainScreenFragment()).commit()
    }
}