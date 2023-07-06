package com.example.data.models

open class DataMigrationMethodInfo

data class Title(
    val text: String? = null,
    val itemType: String? = null
): DataMigrationMethodInfo()

data class Text(
    val text: String? = null,
    val itemType: String? = null
): DataMigrationMethodInfo()

data class Image(
    val imagePath: String? = null,
    val text: String? = null,
    val itemType: String? = null
): DataMigrationMethodInfo()

data class BulletList(
    val text: String? = null,
    val itemType: String? = null
): DataMigrationMethodInfo()
