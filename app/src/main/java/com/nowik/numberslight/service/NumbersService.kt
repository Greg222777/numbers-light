package com.nowik.numberslight.service
import kotlinx.coroutines.flow.Flow
import com.nowik.numberslight.model.Number

interface NumbersService {

    fun getAll() : Flow<List<Number>?>

    fun get(numberId: Int) : Flow<Number?>
}