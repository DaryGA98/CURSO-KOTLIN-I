package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// En esta clase usamos MainActivity y Dice para ejecutar nuestra proyecto de "DADO"//

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // En esta parte aprendimos a invocar los elementos por ID y Asignarle un valor//
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            //rollDice()
            main()


        }

    }
    // Aprendimos a crear un DICE con 6 lados y tirarlo (roll)//

    private fun rollDice() {
        val dice = Dice(8)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }

    fun main() {
        val myFirstDice = Dice(8)
        val rollResult = myFirstDice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = rollResult.toString()
        val luckyNumber = 4

        when (rollResult) {
            luckyNumber -> println("You won!")
            1 -> println("So sorry! You rolled a 1. Try again!")
            2 -> println("Sadly, you rolled a 2. Try again!")
            3 -> println("Unfortunately, you rolled a 3. Try again!")
            5 -> println("Don't cry! You rolled a 5. Try again!")
            6 -> println("Apologies! You rolled a 6. Try again!")
            else -> println("Sorry you have lose, try again")

        }

    }
}

// Aprendimos a mostrar el resultado de RollDice en pantalla//
class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}