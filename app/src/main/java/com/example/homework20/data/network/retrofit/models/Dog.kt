package com.example.homework20.data.network.retrofit.models

data class Dog(
    val breeds: List<Breed>,
    val categories: List<Category>,
    val id: String,
    val url: String
)

data class Category(val id: Int, val name: String)

data class Breed(
    val name: String,
    val temperament: String,
)