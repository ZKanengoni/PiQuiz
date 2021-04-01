package com.example.piquiz

data class Questions(
        val id: Int,
        val difficulty: String,
        val question: String,
        val optionOne: String,
        val optionTwo: String,
        val optionThree: String,
        val optionFour: String,
        val correctOption: Int
)