package com.example.dog.features.dog.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dog.features.dog.domain.usecase.GetDogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val getDogsUseCase: GetDogsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<DogState>(DogState.Loading)
    val state: StateFlow<DogState> = _state

    init {
        getDogs()
    }

    private fun getDogs() {
        getDogsUseCase()
            .onStart {
                _state.value = DogState.Loading
            }
            .onEach { dogs ->
                _state.value = if (dogs.isNotEmpty()) {
                    DogState.Success(dogs)
                } else {
                    DogState.Empty
                }
            }
            .catch { e ->
                _state.value = DogState.Error(
                    message = e.message ?: "Failed to fetch dog breeds"
                )
            }
            .launchIn(viewModelScope)
    }

    fun retry() {
        getDogs()
    }
}