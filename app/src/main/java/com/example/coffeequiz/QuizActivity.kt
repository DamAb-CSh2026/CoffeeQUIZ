package com.example.coffeequiz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class QuizActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        Log.d("CoffeeQuiz", "Викторина открыта")

        val name = intent.getStringExtra("name") ?: "Участник"

        val q1 = findViewById<RadioGroup>(R.id.q1Group)
        val q2 = findViewById<RadioGroup>(R.id.q2Group)
        val q3 = findViewById<RadioGroup>(R.id.q3Group)
        val finishButton = findViewById<Button>(R.id.finishButton)

        finishButton.setOnClickListener {
            if (q1.checkedRadioButtonId == -1 ||
                q2.checkedRadioButtonId == -1 ||
                q3.checkedRadioButtonId == -1
            ) {
                Toast.makeText(
                    this,
                    "Ответьте на все вопросы",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                var score = 0

                if (q1.checkedRadioButtonId == R.id.q1Correct) score++
                if (q2.checkedRadioButtonId == R.id.q2Correct) score++
                if (q3.checkedRadioButtonId == R.id.q3Correct) score++

                Log.d("CoffeeQuiz", "Результат: $score из 3")

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("score", score)
                startActivity(intent)
            }
        }
    }
}
