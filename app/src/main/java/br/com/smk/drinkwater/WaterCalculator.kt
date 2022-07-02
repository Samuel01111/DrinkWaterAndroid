package br.com.smk.drinkwater

class WaterCalculator {

    private var young_ml = 0
    private var mid_age_ml = 0
    private var almost_elderly_ml = 0
    private var elderely_ml = 0

    private var finalWaterQuantity = 0

    private var invalidValue: Boolean = false

    fun calculateQuantityByAge(weight: Int, age: Int, isDoExercisesChecked: Boolean) :Int {
        setMlValuesByUserCheck(isDoExercisesChecked)

        when (age) {
            in 1..17 -> finalWaterQuantity = weight * young_ml
            in 18..55 -> finalWaterQuantity = weight * mid_age_ml
            in 55..65 -> finalWaterQuantity = weight * almost_elderly_ml
            in 66..120 -> finalWaterQuantity = weight * elderely_ml
            else -> invalidValue = true
        }
        return finalWaterQuantity
    }

    private fun setMlValuesByUserCheck(isDoExerciciesChecked: Boolean) {
        when {
            isDoExerciciesChecked -> setValuesChecked()
            else -> setValuesUnchecked()
        }
    }

    private fun setValuesChecked() {
        young_ml = 45
        mid_age_ml = 50
        almost_elderly_ml = 45
        elderely_ml = 35
    }

    private fun setValuesUnchecked() {
        young_ml = 40
        mid_age_ml = 35
        almost_elderly_ml = 30
        elderely_ml = 25
    }
}
