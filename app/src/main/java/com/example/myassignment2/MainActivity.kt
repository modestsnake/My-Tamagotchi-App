package com.example.myassignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val purple = findViewById<ImageView>(R.id.purple)
        val peter = findViewById<TextView>(R.id.peter)
        val bear = findViewById<ImageView>(R.id.bear)

        val start = findViewById<Button>(R.id.start)
        start.setOnClickListener{
            Toast.makeText(this@MainActivity, "Getting started!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, MainActivity02::class.java)
            startActivity(intent) }
        }
    }
