package com.example.coffeequiz

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name = intent.getStringExtra("name") ?: "Участник"
        val score = intent.getIntExtra("score", 0)

        findViewById<TextView>(R.id.resultText).text =
            "$name, ваш результат: $score из 3"

        Log.d("CoffeeQuiz", "Экран результата открыт")
    }
}
