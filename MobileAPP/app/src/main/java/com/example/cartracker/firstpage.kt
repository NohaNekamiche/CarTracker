package com.example.cartracker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class firstpage : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstpage)
       handler = Handler()
        handler.postDelayed({

            // Delay and Start Activity
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        } , 1000) // here we're delaying to startActivity after 2seconds

    }
}