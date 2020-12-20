package com.example.cartracker.authentification

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cartracker.APIRessources.DriverViewModel
import com.example.cartracker.APIRessources.DriverViewModelFactory
import com.example.cartracker.APIRessources.Repository.Repository
import com.example.cartracker.R
import com.example.cartracker.menu_drawer

class login_page : AppCompatActivity() {

    private lateinit var viewModel : DriverViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        val log_btn :Button
        val signUp : Button
        val forget_pwd = findViewById<TextView>(R.id.forget_pwd)
        log_btn = findViewById(R.id.login)
        signUp = findViewById(R.id.singUp)

        val repository =Repository()
        val viewModelFactory=DriverViewModelFactory(repository)
  //      viewModel = ViewModelProvider(this,viewModelFactory).get(DriverViewModel::class.java)
//        viewModel.getDriver()
        log_btn.setOnClickListener {
            val email=findViewById<EditText>(R.id.email).text.toString().trim()
            val pwd=findViewById<EditText>(R.id.pwd).text.toString().trim()
            if(email.isEmpty()){
                findViewById<EditText>(R.id.email).error= "Email Erroner"
                findViewById<EditText>(R.id.email).requestFocus()
                return@setOnClickListener
            }
            if(pwd.isEmpty()){
                findViewById<EditText>(R.id.email).error= "Email Erroner"
                findViewById<EditText>(R.id.email).requestFocus()
                return@setOnClickListener
            }


            val intent = Intent(this@login_page, menu_drawer::class.java)
            startActivity(intent)
        }
        signUp.setOnClickListener{
            val intent = Intent(this@login_page, Inscription_page::class.java)
            startActivity(intent)
        }
        forget_pwd.setOnClickListener {
            val intent = Intent(this@login_page,Forget_Pwd::class.java)
            startActivity(intent)
        }

    }
}