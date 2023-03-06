package com.saproduction.quizapp.DataClass

import com.saproduction.quizapp.R

object Constants {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTION = "total_question"
    const val CORRECT_ANSWER = "correct_answer"

    fun getQuestion(): List<Question> {

        var questions = ArrayList<Question>()

        var question1 = Question(1, R.drawable.australia, "America", "Nepal",
        "SwizerLand", "Australia", 4
            )
        questions.add(question1)

        var question2 = Question(2, R.drawable.brazil, "Brazil", "Argentina",
            "Morocco", "Portugal", 1
        )
        questions.add(question2)

        var question3 = Question(3, R.drawable.canada, "America", "Canada",
            "SwizerLand", "Australia", 2
        )
        questions.add(question3)

        var question4 = Question(4, R.drawable.nepal, "India", "China",
            "Pakistan", "Nepal", 4
        )
        questions.add(question4)

        var question5 = Question(5, R.drawable.uk, "America", "India",
            "United Kingdom", "Hong Kong", 3
        )
        questions.add(question5)



        return questions

    }

}