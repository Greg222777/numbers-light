package com.nowik.numberslight.repositories

import com.nowik.numberslight.service.NumbersService

class NumbersRepositoryImpl(
    val numbersService: NumbersService
) : NumbersRepository {

    override fun getAll() = numbersService.getAll()

    override fun get(numberId: Int) = numbersService.get(numberId)
}