package br.com.smk.drinkwater


import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @Mock
    private lateinit var waterCalculator: WaterCalculator

    @Before
    fun setUp() {

    }

    @Test
    fun calculateQuantityByAge() {
        var weight = 1
        var age = 1
        var isDoExercisesChecked = false

        whenever(waterCalculator.calculateQuantityByAge(weight, age, isDoExercisesChecked)).thenReturn(0)

        waterCalculator.calculateQuantityByAge(weight, age, isDoExercisesChecked)


    }

}