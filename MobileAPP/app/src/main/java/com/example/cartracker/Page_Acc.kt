package com.example.cartracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView



class Page_Acc : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar : Toolbar
    lateinit var navView : NavigationView
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page__acc)
       // toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(findViewById(R.id.toolBar))
        drawerLayout = findViewById(R.id.drawer)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this,drawerLayout,findViewById(R.id.toolBar),0,0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.my_car->{
                Toast.makeText(this,"prendre voiture",Toast.LENGTH_LONG).show()
            }
            R.id.deposer->{
                Toast.makeText(this,"deposer voiture",Toast.LENGTH_LONG).show()
            }
            R.id.service->{
                Toast.makeText(this,"services de maintenace",Toast.LENGTH_LONG).show()
            }
            R.id.add_fuel->{
                Toast.makeText(this,"Ajouter carburant ",Toast.LENGTH_LONG).show()
            }
            R.id.reminder->{
                Toast.makeText(this,"Reminder ",Toast.LENGTH_LONG).show()
            }
            R.id.trajet->{
                Toast.makeText(this,"Trajet",Toast.LENGTH_LONG).show()
            }
            R.id.setting->{
                Toast.makeText(this,"settings ",Toast.LENGTH_LONG).show()
            }
            R.id.about_us->{
                Toast.makeText(this,"A propos nous ",Toast.LENGTH_LONG).show()
            }
            R.id.repport->{
                Toast.makeText(this,"Repporter",Toast.LENGTH_LONG).show()
                val intent = Intent(this, Repport_page::class.java)
                startActivity(intent)
                finish()
            }
            R.id.logout->{
                Toast.makeText(this,"sign out ",Toast.LENGTH_LONG).show()
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}