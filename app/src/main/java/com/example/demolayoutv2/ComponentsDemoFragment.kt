package com.example.demolayoutv2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import kotlin.math.floor
import kotlin.math.roundToInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ComponentsDemoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComponentsDemoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var roundUpSwitchVal = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_components_demo, container, false)

        var tipOption = 0.2
        val radioButtonGroup = rootView.findViewById<RadioGroup>(R.id.tip_options)
        radioButtonGroup.setOnCheckedChangeListener { radioButtonGroup, optionId ->
            run {
                when (optionId) {
                    R.id.option_twenty_percent -> {
                        Toast.makeText(requireContext(), R.string.amazing_service, Toast.LENGTH_SHORT).show()
                        Log.d("Service clicked", R.string.amazing_service.toString())
                        tipOption = 0.2
                    }

                    R.id.option_eighteen_percent -> {
                        Toast.makeText(requireContext(), getString(R.string.good_service), Toast.LENGTH_SHORT).show()
                        Log.d("Service clicked", R.string.good_service.toString())
                        tipOption = 0.18
                    }

                    R.id.option_fifteen_percent -> {
                        Toast.makeText(requireContext(), getString(R.string.ok_service), Toast.LENGTH_SHORT).show()
                        Log.d("Service clicked", R.string.ok_service.toString())
                        tipOption = 0.15
                    }
                }
            }
        }

        // Switch
        val roundUpSwitch = rootView.findViewById<Switch>(R.id.round_up_switch)
        roundUpSwitch.setOnCheckedChangeListener() { btn, isChecked ->
            if (isChecked) {
                // Toast.makeText(requireContext(), "Checked", Toast.LENGTH_SHORT).show()
                Log.d("Round up switch", "checked")
                roundUpSwitchVal = true
            } else {
                // Toast.makeText(requireContext(), "Unchecked", Toast.LENGTH_SHORT).show()
                Log.d("Round up switch", "unchecked")
                roundUpSwitchVal = false
            }
        }

        val calcBtn = rootView.findViewById<Button>(R.id.calculate_button)
        calcBtn.setOnClickListener {
            val inputCostEditText = rootView.findViewById<EditText>(R.id.cost_of_service)
            var inputCost:Int = 0
            if (inputCostEditText.text.isNotEmpty())
                inputCost = inputCostEditText.text.toString().toInt()
            val tipAmount = inputCost * tipOption
            val totalPrice = inputCost + tipAmount

            val tipResultValue = rootView.findViewById<TextView>(R.id.tip_result_value)
            val totalResultValue = rootView.findViewById<TextView>(R.id.total_result_value)

            tipResultValue.text = tipAmount.toString()

            if(roundUpSwitchVal) {
                totalResultValue.text = totalPrice.roundToInt().toString()
            }
            else {
                totalResultValue.text = totalPrice.toString()
            }
        }

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ComponentsDemoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ComponentsDemoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}