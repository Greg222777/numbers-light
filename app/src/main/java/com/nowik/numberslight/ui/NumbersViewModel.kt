package com.nowik.numberslight.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowik.numberslight.model.Number
import com.nowik.numberslight.repositories.NumbersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class NumbersViewModel(private val numbersRepository: NumbersRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(NumbersUiState())

    fun getAll() = viewModelScope.launch(Dispatchers.IO) {
        numbersRepository.getAll().firstOrNull {
            true
        }
    }

    fun getNumberDetails(numberId : Int)  = viewModelScope.launch(Dispatchers.IO) {
        numbersRepository.get(numberId).firstOrNull {
            true
        }
    }
}

data class NumbersUiState(
    var numbers: MutableState<List<Number>> = mutableStateOf(listOf()),
    var selectedNumber: MutableState<Number?> = mutableStateOf(null)
)