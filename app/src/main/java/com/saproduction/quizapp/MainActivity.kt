package com.saproduction.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.saproduction.quizapp.DataClass.Constants
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startButton: Button = findViewById(R.id.startBtn)
        var nameTv: TextView = findViewById(R.id.name_tv)

        startButton.setOnClickListener {

            if(nameTv.text.isEmpty()) {
                Toast.makeText(this, "Please Insert Name.", Toast.LENGTH_SHORT).show()
            }else {
                var intent = Intent(this, ShowQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, nameTv.text.toString())
                startActivity(intent)
                finish()
            }

        }

    }
}