package com.migration.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.migration.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class CountryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        val country = intent.getSerializableExtra("country") as com.migration.domain.models.Country
        println(country)

        lifecycleScope.launch {
            val methods = getMethods(country.methods_path?:"")
            methods.forEach {
                println(it)
            }
        }
    }

    private suspend fun getMethods(path: String):
            List<Method> = withContext(Dispatchers.IO) {
        val db = Firebase.firestore
        val countriesCollection = db.collection(path)
        val methodList = mutableListOf<Method>()

        val querySnapshot = countriesCollection.get().await()
        for (document in querySnapshot) {
            val method = document.toObject(Method::class.java)
            methodList.add(method)
        }
        return@withContext methodList
    }
}