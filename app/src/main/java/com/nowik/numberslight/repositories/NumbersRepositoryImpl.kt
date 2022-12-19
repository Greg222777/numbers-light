package com.nowik.numberslight.repositories

import com.nowik.numberslight.service.NumbersService

class NumbersRepositoryImpl(
    private val numbersService: NumbersService
) : NumbersRepository {

    override fun getAll() = numbersService.getAll()
    override fun get(numberId: String) = numbersService.get(numberId)
}