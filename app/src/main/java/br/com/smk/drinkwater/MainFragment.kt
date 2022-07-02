package br.com.smk.drinkwater

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.smk.drinkwater.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var viewModel: MainViewModel = MainViewModel()
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var currentWeight: Int = 0
    private var currentAge: Int = 0
    private var isExercisesChecked: Boolean = false

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBackgroundAnimation()
        listenToButtonFirstClick()
        listenToButtonCalculatorWaterClick()
        listenToCopyrightTextClick()
    }

    private fun setBackgroundAnimation() {
        val animationDrawable: AnimationDrawable =
            binding.constraintLayoutMain.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

    private fun listenToButtonFirstClick() {
        binding.nextScreenButton.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_SettingsFragment)
        }
    }

    private fun listenToButtonCalculatorWaterClick() {
        binding.buttonCalculatorWater.setOnClickListener {
            if (errorValidator()) {
                Toast.makeText(context, R.string.error_message_value_age_weight, Toast.LENGTH_SHORT).show()
            } else {
                setUserValueOnScreen()
            }
        }
    }

    private fun listenToCopyrightTextClick() {
        binding.textviewCopyrightJoke.setOnClickListener {
            Toast.makeText(context, R.string.error_message_joke, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUserValueOnScreen() {
        currentWeight = binding.textYourWeight.text.toString().toInt()
        currentAge = binding.textYourAge.text.toString().toInt()
        isExercisesChecked = binding.checkboxExercises.isChecked

        val finalMlByAge = viewModel.calculateQuantityByAge(
            currentWeight,
            currentAge,
            isExercisesChecked
        ).toString()

        binding.currentWeightText.text = finalMlByAge
    }

    private fun errorValidator(): Boolean {
        return binding.textYourWeight.text.isNullOrEmpty() ||
                binding.textYourAge.text.isNullOrEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
