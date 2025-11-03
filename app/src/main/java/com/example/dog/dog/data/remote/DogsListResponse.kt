package com.example.dog.features.dog.data.remote

data class DogsListResponse(
    val message: Map<String, List<String>>, // This matches the API: "breed": ["subbreed1", "subbreed2"]
    val status: String
)