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
