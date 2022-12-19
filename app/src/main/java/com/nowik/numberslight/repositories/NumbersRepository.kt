package com.nowik.numberslight.repositories

import kotlinx.coroutines.flow.Flow
import com.nowik.numberslight.model.Number

interface NumbersRepository  {
    fun getAll() : Flow<List<Number>?>
    fun get(numberId: String) : Flow<Number?>
}