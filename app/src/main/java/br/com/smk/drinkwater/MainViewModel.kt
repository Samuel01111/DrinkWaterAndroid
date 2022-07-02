package br.com.smk.drinkwater

class MainViewModel: BaseViewModel() {

    var currentWeight: String? = null
    var currentAge: String? = null

    private var waterCalculator = WaterCalculator()

    fun calculateQuantityByAge(weight: Int, age: Int, isDoExercisesChecked: Boolean) {
        waterCalculator.calculateQuantityByAge(weight, age, isDoExercisesChecked)
    }
}
