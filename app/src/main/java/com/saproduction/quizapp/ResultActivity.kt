package com.saproduction.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.button.MaterialButtonToggleGroup
import com.saproduction.quizapp.DataClass.Constants
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // getting data from intent
        var userName = intent.getStringExtra(Constants.USER_NAME)
        var correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER, 0)
        var totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTION, 0)

        var userNameTv: TextView = findViewById(R.id.username_tv)
        var scoreTv: TextView = findViewById(R.id.score_tv)
        var finishBtn: Button = findViewById(R.id.finish_btn)

        userNameTv.text = userName
        scoreTv.text = "You score $correctAnswer out of $totalQuestion"

        finishBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }

    }
}