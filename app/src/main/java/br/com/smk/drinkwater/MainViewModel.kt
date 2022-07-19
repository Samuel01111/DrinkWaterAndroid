package br.com.smk.drinkwater


class MainViewModel : BaseViewModel() {

    private val waterCalculator = WaterCalculator()

    fun calculateQuantityByAge(weight: Int, age: Int, isDoExercisesChecked: Boolean) {
        waterCalculator.calculateQuantityByAge(weight, age, isDoExercisesChecked)
    }
}
