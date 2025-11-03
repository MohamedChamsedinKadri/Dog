package com.example.dog.features.dog.data.remote

data class DogsListResponse(
    val message: Map<String, List<String>>,
    val status: String
)