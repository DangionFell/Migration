package com.example.data.storage

import com.example.data.models.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FirebaseMethodInfoStorage: MethodInfoStorage {
    override suspend fun getInfo(path: String):
            List<DataMigrationMethodInfo> = withContext(Dispatchers.IO) {
        val db = Firebase.firestore
        val itemsCollection = db.collection(path)
        val itemsList = mutableListOf<DataMigrationMethodInfo>()

        val querySnapshot = itemsCollection.get().await()
        for (document in querySnapshot) {

            val item = when (document.getString("itemType")) {
                "Title" -> document.toObject(Title::class.java)
                "Text" -> document.toObject(Text::class.java)
                "Image" -> document.toObject(Image::class.java)
                "BulletList" -> document.toObject(BulletList::class.java)
                else -> null
            }

            item?.let { itemsList.add(it) }
        }
        return@withContext itemsList
    }
}