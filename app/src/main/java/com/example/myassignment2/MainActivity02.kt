package com.example.myassignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity02 : AppCompatActivity() {


    private lateinit var handler: Handler
    private var happinessValue = 100
    private var cleanlinessValue = 100
    private var hungerValue = 100

    private lateinit var Feed: TextView
    private lateinit var Play: TextView
    private lateinit var Clean: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main02)

        Feed = findViewById(R.id.Feed)
        Play = findViewById(R.id.Play)
        Clean = findViewById(R.id.Clean)

        val hunger = findViewById<ImageView>(R.id.hunger)
        val happy = findViewById<ImageView>(R.id.happy)
        val clean = findViewById<ImageView>(R.id.clean)
        val purple = findViewById<ImageView>(R.id.purple)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val bear = findViewById<ImageView>(R.id.bear)
        val one = findViewById<TextView>(R.id.one)
        val two = findViewById<TextView>(R.id.two)
        val three = findViewById<TextView>(R.id.three)

        purple.setImageResource(R.drawable.purple_background)

        hungerValue = 100

        handler = Handler()

        startUpdatingValues()

        button1.setOnClickListener {
            hungerValue = 100
            decreaseHunger(20)
            bear.setImageResource(R.drawable.feeding_icon)
            clean.setImageResource(R.drawable.feeding_icon)
            happy.setImageResource(R.drawable.feeding_icon)
            hunger.setImageResource(R.drawable.feeding_icon)

            val currentHungriness = one.text.toString().toIntOrNull() ?: 0
            val newHungeriness = calculateNewValue(currentHungriness, 100)

            Feed.text = "$newHungeriness"
        }

        button2.setOnClickListener {
            cleanlinessValue = 100
            increaseCleanliness(20)
            bear.setImageResource(R.drawable.clean_icon)
            happy.setImageResource(R.drawable.clean_icon)
            hunger.setImageResource(R.drawable.clean_icon)
            clean.setImageResource(R.drawable.clean_icon)

            val currentCleanliness = two.text.toString().toIntOrNull() ?: 0
            val newCleanliness = calculateNewValue(currentCleanliness, 100)

            Clean.text = "$newCleanliness"
        }

        button3.setOnClickListener {
            happinessValue = 100
            increaseHappiness(20)
            bear.setImageResource(R.drawable.play_icon)
            clean.setImageResource(R.drawable.play_icon)
            hunger.setImageResource(R.drawable.play_icon)
            happy.setImageResource(R.drawable.play_icon)

            val currentHappiness = three.text.toString().toIntOrNull() ?: 0
            val newHappiness = calculateNewValue(currentHappiness, 100)

            Play.text = "$newHappiness"
        }
    }

    private fun startUpdatingValues() {
        handler.postDelayed({
            decreaseHappiness(3)
            decreaseCleanliness(2)
            decreaseHunger(1)
            updateUI()
            startUpdatingValues()
        }, 10000)
    }

    private fun updateUI() {
        Feed.text = hungerValue.toString()
        Play.text = happinessValue.toString()
        Clean.text = cleanlinessValue.toString()

        if (hungerValue <= 60 || happinessValue <= 60 || cleanlinessValue <= 60) {
            sendMessage()
        }
    }

    private fun sendMessage() {
        Toast.makeText(this, "One or more levels are at 60!", Toast.LENGTH_SHORT).show()
    }

    private fun increaseHappiness(amount: Int) {
        happinessValue += amount
        if (happinessValue > 100) happinessValue = 100
    }

    private fun decreaseHappiness(amount: Int) {
        happinessValue -= amount
        if (happinessValue < 0) happinessValue = 0
    }

    private fun increaseCleanliness(amount: Int) {
        cleanlinessValue += amount
        if (cleanlinessValue > 100) cleanlinessValue = 100
    }

    private fun decreaseCleanliness(amount: Int) {
        cleanlinessValue -= amount
        if (cleanlinessValue < 0) cleanlinessValue = 0
    }

    private fun increaseHunger(amount: Int) {
        hungerValue += amount
        hungerValue = hungerValue.coerceAtMost(100)
    }

    private fun decreaseHunger(amount: Int) {
        hungerValue -= amount
        hungerValue = hungerValue.coerceAtLeast(0)
    }

    private fun calculateNewValue(currentValue: Int, change: Int): Int {
        return currentValue + change
    }
}