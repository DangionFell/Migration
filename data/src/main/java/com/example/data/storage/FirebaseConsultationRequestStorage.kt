package com.example.data.storage

import android.annotation.SuppressLint
import com.example.data.models.DataConsultationRequest
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FirebaseConsultationRequestStorage: ConsultationRequestStorage {
    @SuppressLint("SuspiciousIndentation")
    override suspend fun saveRequest(dataConsultationRequest: DataConsultationRequest) =
        withContext(Dispatchers.IO) {
        val db = Firebase.firestore
        val collection = db.collection("Requests")

            collection.add(dataConsultationRequest).await()
            return@withContext
        }
}