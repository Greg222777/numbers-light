package com.nowik.numberslight.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowik.numberslight.model.Number
import com.nowik.numberslight.repositories.NumbersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NumbersViewModel(private val numbersRepository: NumbersRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(NumbersUiState())
    val uiState: StateFlow<NumbersUiState> = _uiState.asStateFlow()

    fun getAll() = viewModelScope.launch(Dispatchers.IO) {
        Log.e("GREG", "GET ALL")
        numbersRepository.getAll().firstOrNull { numbers ->
            _uiState.update { state ->
                Log.e("GREG", "UPDATE UI STATE with ${numbers?.size}")
                state.copy(
                    numbers = mutableStateOf(numbers ?: listOf())
                )
            }
            true
        }
    }

    fun getNumberDetails(numberId: String) = viewModelScope.launch(Dispatchers.IO) {
        numbersRepository.get(numberId).firstOrNull {
            _uiState.update { state ->
                state.copy(
                    selectedNumber = mutableStateOf(it)
                )
            }
            true
        }
    }
}

data class NumbersUiState(
    var numbers: MutableState<List<Number>> = mutableStateOf(listOf()),
    var selectedNumber: MutableState<Number?> = mutableStateOf(null)
)