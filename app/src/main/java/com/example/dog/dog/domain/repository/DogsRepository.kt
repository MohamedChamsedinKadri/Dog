package com.example.dog.features.dog.domain.repository

import com.example.dog.features.dog.domain.model.DogModel
import kotlinx.coroutines.flow.Flow

interface DogsRepository {
    fun getDogs(): Flow<List<DogModel>>
}
