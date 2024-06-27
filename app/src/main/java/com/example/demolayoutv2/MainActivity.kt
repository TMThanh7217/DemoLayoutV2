package com.example.demolayoutv2

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    // for grid view layout only
    private lateinit var gridViewDemo: GridView
    // end

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.demo_drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.demo_nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // set default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

        //setContentView(R.layout.relative_layout_demo)
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

    // This part show the 3 dots on the menu, doesn't seem to break anything?
    /*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.demo_layout_v2_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    */

    // Changing fragment
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            R.id.absolute_layout -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AbsoluteLayoutFragment()).commit()
            R.id.relative_layout -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RelativeLayoutFragment()).commit()
            R.id.constraint_layout -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ConstraintLayoutFragment()).commit()
            R.id.linear_layout -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LinearLayoutFragment()).commit()
            R.id.frame_layout -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FrameLayoutFragment()).commit()
            R.id.grid_view -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, GridViewFragment()).commit()
            R.id.list_view -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListViewFragment()).commit()
            R.id.table_layout -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TableLayoutFragment()).commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
