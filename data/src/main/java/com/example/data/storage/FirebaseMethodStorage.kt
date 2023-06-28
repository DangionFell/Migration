package com.example.data.storage

import com.example.data.models.DataMethod
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FirebaseMethodStorage : MethodStorage {
    override suspend fun getMethodList(path: String):
            List<DataMethod> = withContext(Dispatchers.IO) {
        val db = Firebase.firestore
        val countriesCollection = db.collection(path)
        val methodList = mutableListOf<DataMethod>()

        val querySnapshot = countriesCollection.get().await()
        for (document in querySnapshot) {
            val method = document.toObject(DataMethod::class.java)
            methodList.add(method)
        }
        return@withContext methodList
    }
}