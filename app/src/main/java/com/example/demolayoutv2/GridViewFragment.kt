package com.example.demolayoutv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.example.demolayoutv2.CardItem
import com.example.demolayoutv2.GridViewLayoutAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GridViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GridViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val rootView = inflater.inflate(R.layout.fragment_grid_view, container, false)

        val gridViewDemo = rootView.findViewById<GridView>(R.id.gridViewDemo)
        val cardItemArrayList: ArrayList<CardItem?> = ArrayList<CardItem?>()

        cardItemArrayList.add(CardItem("Chair", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Bird", R.drawable.ic_launcher_foreground))
        cardItemArrayList.add(CardItem("Cat", R.drawable.ic_launcher_foreground))
        cardItemArrayList.add(CardItem("Dog", R.drawable.ic_launcher_foreground))
        cardItemArrayList.add(CardItem("Television", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Phone", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Car", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Fish", R.drawable.ic_launcher_foreground))

        val adapter = GridViewLayoutAdapter(requireContext(), cardItemArrayList)
        gridViewDemo.adapter = adapter

        gridViewDemo.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // Handle item click here
            val selectedItem = adapter.getItem(position)
            // Perform actions based on the selected item

            val text = selectedItem!!.getCardItem_name()
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(requireContext(), text, duration).show()
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
         * @return A new instance of fragment GridViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GridViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}