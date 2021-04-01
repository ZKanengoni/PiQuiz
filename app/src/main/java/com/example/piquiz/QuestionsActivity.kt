package com.example.piquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPos:Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPos: Int = 0
    private var mCorrectAnswers: Int = 0;
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        val que1: TextView = findViewById(R.id.tv_option_one)
        val que2: TextView = findViewById(R.id.tv_option_two)
        val que3: TextView = findViewById(R.id.tv_option_three)
        val que4: TextView = findViewById(R.id.tv_option_four)
        val button: Button = findViewById(R.id.btn_submit)

        que1.setOnClickListener(this)
        que2.setOnClickListener(this)
        que3.setOnClickListener(this)
        que4.setOnClickListener(this)
        button.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        val question  = mQuestionsList!![mCurrentPos-1]
        val button: Button = findViewById(R.id.btn_submit)

        defaultOptionsView()

        if(mCurrentPos == mQuestionsList!!.size){
            button.text = "Finish"
        } else {
            button.text = "Submit"
        }

        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val tvProgress: TextView = findViewById(R.id.tv_progress)
        val tvQuestion: TextView = findViewById(R.id.tv_question)
        val que1: TextView = findViewById(R.id.tv_option_one)
        val que2: TextView = findViewById(R.id.tv_option_two)
        val que3: TextView = findViewById(R.id.tv_option_three)
        val que4: TextView = findViewById(R.id.tv_option_four)


        progressBar.progress = mCurrentPos
        tvProgress.text = "$mCurrentPos" + "/" + progressBar.max

        tvQuestion.text = question!!.question
        que1.text = question.optionOne
        que2.text = question.optionTwo
        que3.text = question.optionThree
        que4.text = question.optionFour

    }

    private fun defaultOptionsView() {
        val que1: TextView = findViewById(R.id.tv_option_one)
        val que2: TextView = findViewById(R.id.tv_option_two)
        val que3: TextView = findViewById(R.id.tv_option_three)
        val que4: TextView = findViewById(R.id.tv_option_four)

        val options = ArrayList<TextView>()
        options.add(0, que1)
        options.add(1, que2)
        options.add(2, que3)
        options.add(3, que4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.defualt_option_border_bg
            )
        }

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        val que1: TextView = findViewById(R.id.tv_option_one)
        val que2: TextView = findViewById(R.id.tv_option_two)
        val que3: TextView = findViewById(R.id.tv_option_three)
        val que4: TextView = findViewById(R.id.tv_option_four)

        when(v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(que1, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(que2, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(que3, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(que4, 4)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPos == 0) {
                    mCurrentPos ++

                    when{
                        mCurrentPos <= mQuestionsList!!.size -1 -> {
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPos -1)
                    val button: Button = findViewById(R.id.btn_submit)
                    if(question!!.correctOption != mSelectedOptionPos ) {
                        answerView(mSelectedOptionPos, R.drawable.incorrect_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctOption, R.drawable.correct_option_border_bg)

                    if(mCurrentPos == mQuestionsList!!.size) {
                        button.text = "Finish"
                    } else {
                        button.text = "Go to next question"
                    }
                    mSelectedOptionPos = 0
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        val que1: TextView = findViewById(R.id.tv_option_one)
        val que2: TextView = findViewById(R.id.tv_option_two)
        val que3: TextView = findViewById(R.id.tv_option_three)
        val que4: TextView = findViewById(R.id.tv_option_four)

         when(answer) {
             1 -> {
                 que1.background = ContextCompat.getDrawable(
                     this, drawableView
                 )
             }
             2 -> {
                 que2.background = ContextCompat.getDrawable(
                     this, drawableView
                 )
             }
             3 -> {
                 que3.background = ContextCompat.getDrawable(
                     this, drawableView
                 )
             }
             4 -> {
                 que4.background = ContextCompat.getDrawable(
                     this, drawableView
                 )
             }
         }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPos = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

}