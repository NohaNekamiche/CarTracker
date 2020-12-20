package com.example.cartracker.authentification

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.cartracker.R

class Forget_Pwd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget__pwd)
        val save_btn =findViewById<Button>(R.id.back_to_login)
        save_btn.setOnClickListener {
            val pwdNew=findViewById<EditText>(R.id.pwdNew).text.toString().trim()
            val pwdConfirm=findViewById<EditText>(R.id.pwdConfirm).text.toString().trim()
            if(pwdNew.isEmpty()){
                findViewById<EditText>(R.id.pwdNew).error= "Email Erroner"
                findViewById<EditText>(R.id.pwdNew).requestFocus()
                return@setOnClickListener
            }
            if(pwdConfirm.isEmpty()){
                findViewById<EditText>(R.id.pwdConfirm).error= "Email Erroner"
                findViewById<EditText>(R.id.pwdConfirm).requestFocus()
                return@setOnClickListener
            }

            val intent = Intent(this@Forget_Pwd,login_page::class.java)
            startActivity(intent)
        }
    }
}