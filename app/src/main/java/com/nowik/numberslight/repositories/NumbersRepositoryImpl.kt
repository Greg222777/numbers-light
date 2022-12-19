package com.nowik.numberslight.repositories

import com.nowik.numberslight.model.Number
import com.nowik.numberslight.service.NumbersService
import kotlinx.coroutines.flow.Flow

class NumbersRepositoryImpl(
    val numbersService: NumbersService
) : NumbersRepository {

    override fun getAll() = numbersService.getAll()
    override fun get(numberId: String) = numbersService.get(numberId)
}