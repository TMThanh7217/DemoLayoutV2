package com.example.demolayoutv2

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ComponentsDemo2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComponentsDemo2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val handler = Handler()


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
        val rootView = inflater.inflate(R.layout.fragment_components_demo2, container, false)

        // Radio Button
        val radioButtonGroup = rootView.findViewById<RadioGroup>(R.id.radioGroupDemo)
        radioButtonGroup.setOnCheckedChangeListener { radioBtnGroup, optionId ->
            run {
                when (optionId) {
                    R.id.radio_btn_1 -> {
                        Toast.makeText(requireContext(), "Button 1 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 1 clicked")
                    }

                    R.id.radio_btn_2 -> {
                        Toast.makeText(requireContext(), "Button 2 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 2 clicked")
                    }

                    R.id.radio_btn_3 -> {
                        Toast.makeText(requireContext(), "Button 3 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 3 clicked")
                    }

                    R.id.radio_btn_4 -> {
                        Toast.makeText(requireContext(), "Button 4 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 4 clicked")
                    }

                    R.id.radio_btn_5 -> {
                        Toast.makeText(requireContext(), "Button 5 clicked", Toast.LENGTH_SHORT).show()
                        Log.d("Radio button clicked", "Button 5 clicked")
                    }
                }
            }
        }

        // Check box
        rootView.findViewById<CheckBox>(R.id.checkbox_1)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked) {
                    Toast.makeText(requireContext(), "Checkbox 1 checked", Toast.LENGTH_SHORT).show()
                    Log.d("check box checked", "Checkbox 1 checked")
                }
                else {
                    Toast.makeText(requireContext(), "Checkbox 1 unchecked", Toast.LENGTH_SHORT).show()
                    Log.d("check box unchecked", "Checkbox 1 unchecked")
                }
            }

        rootView.findViewById<CheckBox>(R.id.checkbox_2)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked) {
                    Toast.makeText(requireContext(), "Checkbox 2 checked", Toast.LENGTH_SHORT).show()
                    Log.d("check box checked", "Checkbox 2 checked")
                }
                else {
                    Toast.makeText(requireContext(), "Checkbox 2 unchecked", Toast.LENGTH_SHORT).show()
                    Log.d("check box unchecked", "Checkbox 2 unchecked")
                }
            }

        rootView.findViewById<CheckBox>(R.id.checkbox_3)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked) {
                    Toast.makeText(requireContext(), "Checkbox 3 checked", Toast.LENGTH_SHORT).show()
                    Log.d("check box checked", "Checkbox 3 checked")
                }
                else {
                    Toast.makeText(requireContext(), "Checkbox 3 unchecked", Toast.LENGTH_SHORT).show()
                    Log.d("check box unchecked", "Checkbox 3 unchecked")
                }
            }

        rootView.findViewById<CheckBox>(R.id.checkbox_4)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked) {
                    Toast.makeText(requireContext(), "Checkbox 4 checked", Toast.LENGTH_SHORT).show()
                    Log.d("check box checked", "Checkbox 4 checked")
                }
                else {
                    Toast.makeText(requireContext(), "Checkbox 4 unchecked", Toast.LENGTH_SHORT).show()
                    Log.d("check box unchecked", "Checkbox 4 unchecked")
                }
            }

        rootView.findViewById<CheckBox>(R.id.checkbox_5)
            .setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked) {
                    Toast.makeText(requireContext(), "Checkbox 5 checked", Toast.LENGTH_SHORT).show()
                    Log.d("check box checked", "Checkbox 5 checked")
                }
                else {
                    Toast.makeText(requireContext(), "Checkbox 5 unchecked", Toast.LENGTH_SHORT).show()
                    Log.d("check box unchecked", "Checkbox 5 unchecked")
                }
            }

        // Progress bar
        val progressBarDuration = rootView.findViewById<TextView>(R.id.progressBarText)
        val progressBarBtn = rootView.findViewById<Button>(R.id.progressBarButton)
        val progressBarDemo = rootView.findViewById<ProgressBar>(R.id.progressBar)
        var index = progressBarDemo.progress

        progressBarBtn.setOnClickListener {
            Thread(Runnable {
                while (index < 100) {
                    index++
                    handler.post(Runnable {
                        progressBarDemo.progress = index
                        progressBarDuration!!.text = index.toString() + "/" + progressBarDemo.max
                    })
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }).start()
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
         * @return A new instance of fragment ComponentsDemo2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ComponentsDemo2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}