package com.example.dog.features.dog.data.repository

import com.example.dog.features.dog.data.remote.DogsApiService
import com.example.dog.features.dog.domain.model.DogModel
import com.example.dog.features.dog.domain.repository.DogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DogsRepositoryImpl @Inject constructor(
    private val api: DogsApiService
) : DogsRepository {

    override fun getDogs(): Flow<List<DogModel>> = flow {
        try {
            val response = api.getDogBreeds()
            if (response.status == "success") {
                val dogs = mutableListOf<DogModel>()

                response.message.forEach { (breed, subBreeds) ->
                    if (subBreeds.isEmpty()) {
                        dogs.add(DogModel(breed = breed, subBreed = null))
                    } else {
                        subBreeds.forEach { subBreed ->
                            dogs.add(DogModel(breed = breed, subBreed = subBreed))
                        }
                    }
                }

                emit(dogs)
            } else {
                emit(emptyList())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}