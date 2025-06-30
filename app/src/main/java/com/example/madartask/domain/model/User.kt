package com.example.madartask.domain.model


data class User(
    val id: Int = 0, // Optional if auto-generated
    val name: String,
    val age: Int,
    val jobTitle: String,
    val gender: String
)
