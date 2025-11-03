package com.example.dog.features.dog.domain.usecase

import com.example.dog.features.dog.domain.repository.DogsRepository
import javax.inject.Inject

class GetDogsUseCase @Inject constructor(
    private val repo: DogsRepository
) {
    operator fun invoke() = repo.getDogs()
}
