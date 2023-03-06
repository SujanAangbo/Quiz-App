package com.saproduction.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.saproduction.quizapp.DataClass.Constants
import com.saproduction.quizapp.DataClass.Question

var mQuestionList: List<Question>? = null
var mSelectedOption: Int = 0

var flagImage: ImageView? = null
var progressBar: ProgressBar? = null
var progressTv: TextView? = null
var option1: TextView? = null
var option2: TextView? = null
var option3: TextView? = null
var option4: TextView? = null

var submitBtn: Button? = null

var mUserName: String? = null
var totalCorrectAnswer: Int = 0

class ShowQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        totalCorrectAnswer = 0

        flagImage = findViewById(R.id.flag_img)
        progressBar = findViewById(R.id.progressBar)
        progressTv = findViewById(R.id.progress_tv)
        option1 = findViewById(R.id.option1_tv)
        option2 = findViewById(R.id.option2_tv)
        option3 = findViewById(R.id.option3_tv)
        option4 = findViewById(R.id.option4_tv)
        submitBtn = findViewById(R.id.submit_btn)

        mQuestionList = Constants.getQuestion();
        showQuestion()


    }

    var currentQuestion = 0

    fun selectedOption(view: View) {

        when (view.id) {
            R.id.option1_tv -> mSelectedOption = 1;
            R.id.option2_tv -> mSelectedOption = 2;
            R.id.option3_tv -> mSelectedOption = 3;
            R.id.option4_tv -> mSelectedOption = 4;
        }

        optionsToDefault()

        // add selected_bg to the clicked tv.
        view.setBackgroundResource(R.drawable.selected_bg)
        (view as TextView).setTextColor(ContextCompat.getColor(this,R.color.purple_500))

    }

    private fun optionsToDefault() {
        // this is to make the tv to default
        option1?.setBackgroundResource(R.drawable.option_bg)
        option1?.setTextColor(ContextCompat.getColor(this, R.color.black))
        option2?.setBackgroundResource(R.drawable.option_bg)
        option2?.setTextColor(ContextCompat.getColor(this, R.color.black))
        option3?.setBackgroundResource(R.drawable.option_bg)
        option3?.setTextColor(ContextCompat.getColor(this, R.color.black))
        option4?.setBackgroundResource(R.drawable.option_bg)
        option4?.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    fun markOption(option: Int, drawable: Int) {

        when(option) {
            1 -> {
                option1?.background = ContextCompat.getDrawable(this, drawable)
            }

            2 -> {
                option2?.background = ContextCompat.getDrawable(this, drawable)
            }

            3 -> {
                option3?.background = ContextCompat.getDrawable(this, drawable)
            }

            4 -> {
                option4?.background = ContextCompat.getDrawable(this, drawable)
            }
        }

    }

    fun checkCorrectOption() {

        var question = mQuestionList!![currentQuestion - 1]

        if(mSelectedOption == 0) {
        }else if(question.answer != mSelectedOption) {
            markOption(mSelectedOption, R.drawable.incorrect_option)
        }else {
            totalCorrectAnswer++
        }

        markOption(question.answer, R.drawable.correct_option)

    }


    fun showQuestion() {

        optionsToDefault()
        currentQuestion++
        mSelectedOption = 0

        var question = mQuestionList!![currentQuestion - 1]

        flagImage?.setImageResource(question.image)
        progressBar?.progress = currentQuestion
        progressTv?.text = "$currentQuestion/${mQuestionList!!.size}"
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4

    }

    fun submitOption(view: View) {

        if((view as Button).text == "Submit") {


            checkCorrectOption()
            if(currentQuestion == mQuestionList!!.size) {
                view.text = "Finish"
            }else {
                view.text = "Next Question"
            }
        }else if((view as Button).text == "Finish") {
            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.USER_NAME, mUserName)
            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList!!.size)
            intent.putExtra(Constants.CORRECT_ANSWER, totalCorrectAnswer)

            startActivity(intent)
            finishAffinity()
        }else {

            if (currentQuestion > mQuestionList!!.size) {
                Toast.makeText(this, "Question Finished", Toast.LENGTH_SHORT).show()
            }else {
                showQuestion()
                view.text = "Submit"
            }

        }

    }
}