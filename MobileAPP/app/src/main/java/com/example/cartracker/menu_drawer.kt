package com.example.cartracker

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cartracker.ui.Rappels.RappelsFragment
import com.example.cartracker.ui.Trajet.TrajetFragment
import com.example.cartracker.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class menu_drawer : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var homeFragement: HomeFragment
    lateinit var rappelsFragment: RappelsFragment
    lateinit var trajetFragment: TrajetFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
      // val navBottom : BottomNavigationView = findViewById(R.id.Botton_nav_view)
        /*val homeFragement= HomeFragment()
        val rappelsFragment=RappelsFragment()
        val trajetFragment = TrajetFragment()*/


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       /* navBottom.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
             R.id.id_home ->{
                 homeFragement= HomeFragment()
                 supportFragmentManager.beginTransaction()
                         .replace(R.id.nav_host_fragment,homeFragement)
                         .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                         .commit()

                }
             R.id.id_trajet->{
                 trajetFragment= TrajetFragment()
                 supportFragmentManager.beginTransaction()
                         .replace(R.id.nav_host_fragment,trajetFragment)
                         .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                         .commit()
             }
             R.id.id_car-> {
                 homeFragement= HomeFragment()
                 supportFragmentManager.beginTransaction()
                         .replace(R.id.nav_host_fragment,homeFragement)
                         .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                         .commit()
             }
             R.id.id_rappels-> {
                 rappelsFragment=RappelsFragment()
                 supportFragmentManager.beginTransaction()
                         .replace(R.id.nav_host_fragment,rappelsFragment)
                         .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                         .commit()
             }
         }
            true
        }*/
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_addFuel,
            R.id.nav_reminder,R.id.nav_trajet,R.id.nav_setting,R.id.nav_about_us), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val bottomNavView: BottomNavigationView = findViewById(R.id.Botton_nav_view)
        bottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    private val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.id_home -> {
                        val fragment = HomeFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.javaClass.simpleName).commit()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.id_trajet-> {
                        val fragment = TrajetFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.javaClass.simpleName).commit()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.id_car -> {
                        val fragment = HomeFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.javaClass.simpleName).commit()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.id_rappels->{
                        val fragment = RappelsFragment()
                        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment, fragment.javaClass.simpleName).commit()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    private fun makeCurrentFragment(fragment: Fragment)=
            supportFragmentManager.beginTransaction().apply{
            replace(R.id.nav_host_fragment,fragment)
                commit()
    }
}