package com.example.dog.features.dog.data.remote

import retrofit2.http.GET

interface DogsApiService {
    @GET("breeds/list/all")
    suspend fun getDogBreeds(): DogsListResponse
}