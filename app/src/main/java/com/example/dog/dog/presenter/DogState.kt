package com.example.dog.features.dog.presenter

import com.example.dog.features.dog.domain.model.DogModel

sealed class DogState {
    data object Loading : DogState()
    data class Success(val dogs: List<DogModel>) : DogState()
    data class Error(val message: String) : DogState()
    data object Empty : DogState()
}
