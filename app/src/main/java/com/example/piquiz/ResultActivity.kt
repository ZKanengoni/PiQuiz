package com.example.piquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val name: TextView = findViewById(R.id.tv_name)
        val score: TextView = findViewById(R.id.tv_score)
        val button: Button = findViewById(R.id.btn_finish)

        val username = intent.getStringExtra(Constants.USER_NAME)
        name.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        score.text = "Your Score is $correctAnswer out of $totalQuestions"

        button.setOnClickListener {
        startActivity(Intent(this, MainActivity::class.java))
        }

    }
}