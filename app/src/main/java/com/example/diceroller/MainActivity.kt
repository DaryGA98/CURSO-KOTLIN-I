package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
            rollDice()



        }

    }
    // Aprendimos a crear un DICE con 6 lados y tirarlo (roll)//

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)


    }

    fun main() {
        val myFirstDice = Dice(8)
        val rollResult = myFirstDice.roll()

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