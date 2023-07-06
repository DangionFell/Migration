package com.example.domain.models

open class MigrationMethodInfo

data class Title(
    val text: String
): MigrationMethodInfo()

data class Text(
    val text: String
): MigrationMethodInfo()

data class Image(
    val imagePath: String,
    val text: String
): MigrationMethodInfo()

data class BulletList(
    val list: List<String>
): MigrationMethodInfo()