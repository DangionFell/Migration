package com.example.migration.presentation.methodinfoscreen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.domain.models.MigrationMethod
import com.example.migration.R

class MethodInfoActivity : AppCompatActivity() {

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method_info)

        val method = intent.getSerializableExtra(ARG_METHOD) as MigrationMethod

        supportFragmentManager.beginTransaction().replace(
            R.id.frame,
            MethodInfoFragment.newInstance(method)
        ).commit()
    }

    companion object {
        private const val ARG_METHOD = "method"
    }
}