package com.example.demolayoutv2

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    // for grid view layout only
    private lateinit var gridViewDemo: GridView
    // end

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // grid view layout demo code
        /*setContentView(R.layout.grid_view_layout)
        gridViewDemo = findViewById(R.id.gridViewDemo)
        val cardItemArrayList: ArrayList<CardItem?> = ArrayList<CardItem?>()

        cardItemArrayList.add(CardItem("Chair", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Bird", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Cat", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Dog", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Television", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Phone", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Car", R.drawable.ic_launcher_background))
        cardItemArrayList.add(CardItem("Fish", R.drawable.ic_launcher_background))

        val adapter = GridViewLayoutAdapter(this, cardItemArrayList)
        gridViewDemo.adapter = adapter*/
        // end grid view demo

        // list view layout demo code
        /*setContentView(R.layout.list_view_layout)
        val arrayAdapter: ArrayAdapter<*>
        val myOsValue = arrayOf(
            "Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
            "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
            "Android", "iPhone", "WindowsMobile"
        )

        // access the listView from xml file
        var listViewDemo = findViewById<ListView>(R.id.listViewDemo)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myOsValue)
        listViewDemo.adapter = arrayAdapter*/
        // end list view layout demo

        val text = "Hello toast!"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(this, text, duration).show()

    }
}
