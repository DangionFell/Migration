package com.migration.data.storage

import com.example.data.models.DataCountry
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private const val COUNTRIES_PATH = "Countries"

class FirebaseCountryStorage: CountryStorage {

    override suspend fun getList() : List<DataCountry> = withContext(Dispatchers.IO) {

        val db = Firebase.firestore
        val countriesCollection = db.collection(COUNTRIES_PATH)
        val dataCountryList = mutableListOf<DataCountry>()

        val querySnapshot = countriesCollection.get().await()
        for (document in querySnapshot) {
            val dataCountry = document.toObject(DataCountry::class.java)
            dataCountryList.add(dataCountry)
        }
        return@withContext dataCountryList
    }

}