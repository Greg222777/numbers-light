package com.nowik.numberslight

import com.nowik.numberslight.repositories.NumbersRepository
import com.nowik.numberslight.ui.viewmodels.NumbersViewModel
import kotlinx.coroutines.flow.flow
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import com.nowik.numberslight.model.Number

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NumbersViewModelTests {

    private val mockNumbersRepository = mock<NumbersRepository>()
    private val mockNumbers = listOf(
        Number("1", "testUrl"),
        Number("999", "testUrl2")
    )

    private val vm = NumbersViewModel(mockNumbersRepository)

    @Before
    fun setup() {
        Mockito.`when`(mockNumbersRepository.getAll())
            .thenReturn(
                flow { emit(mockNumbers) }
            )
    }

    @Test
    fun addition_isCorrect() {
        assertTrue(vm.uiState.value.numbers.value.isEmpty())

        vm.getAll()

        // pause test thread because the vm is async and ui state isn't updated right away
        Thread.sleep(200)

        assertEquals(mockNumbers, vm.uiState.value.numbers.value)
    }
}