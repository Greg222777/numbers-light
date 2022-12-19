package com.nowik.numberslight.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowik.numberslight.model.Number
import com.nowik.numberslight.repositories.NumbersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NumberDetailsViewModel(private val numbersRepository: NumbersRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(NumberDetailsUiState())
    val uiState: StateFlow<NumberDetailsUiState> = _uiState.asStateFlow()

    fun getNumberDetails(numberId: String) = viewModelScope.launch(Dispatchers.IO) {
        if (uiState.value.number.value?.id != numberId) {
            numbersRepository.get(numberId).firstOrNull {
                _uiState.update { state ->
                    state.copy(
                        number = mutableStateOf(it)
                    )
                }
                true
            }
        }
    }
}

data class NumberDetailsUiState(
    var number: MutableState<Number?> = mutableStateOf(null)
)