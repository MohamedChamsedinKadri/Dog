package com.example.dog.features.dog.domain.model

data class DogModel(
    val breed: String,
    val subBreed: String? = null
) {
    val displayName: String
        get() = if (subBreed != null) {
            "$subBreed $breed"
        } else {
            breed.replaceFirstChar { it.uppercase() }
        }
}