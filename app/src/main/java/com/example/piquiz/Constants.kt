package com.example.piquiz

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions() : ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(1,"medium","How many zeros are there in a googol?",
                "100",
                "1,000,000",
                "10",
                "1,000",
                1
        )

        questionsList.add(que1)

        val que2 = Questions(2,"medium","What are the first 6 digits of the number 'Pi'?",
                "3.14169",
                "3.14159",
                "3.12423",
                "3.25812",
                2
        )

        questionsList.add(que2)

        val que3 = Questions(3,"easy","In Roman Numerals, what does XL equate to?",
                "15",
                "60",
                "90",
                "40",
                4
        )

        questionsList.add(que3)

        val que4 = Questions(4,	"hard","How many zeptometres are inside one femtometre?",
                "10",
                "1,000,000,000",
                "1,000,000",
                "1000",
                3
        )

        questionsList.add(que4)

        val que5 = Questions(5,	"medium","What Greek letter is used to signify summation?",
                "Omega",
                "Sigma",
                "Delta",
                "Alpha",
                2
        )

        questionsList.add(que5)

        val que6 = Questions(6,	"easy",	"The metric prefix 'atto' makes a measurement how much smaller than the base unit?",
                "One Billionth",
                "One Quadrillionth",
                "One Septillionth",
                "One Quintillionth",
                4
        )

        questionsList.add(que6)

        val que7 = Questions(7,	"easy",	"How many sides does a heptagon have?",
                "8",
                "7",
                "6",
                "5",
                2
        )

        questionsList.add(que7)

        val que8 = Questions(8,	"easy","How many sides does a trapezium have?",
                "4",
                "5",
                "3",
                "6",
                1
        )

        questionsList.add(que8)

        val que9 = Questions(9,	"medium","Which greek mathematician ran through the streets of Syracuse naked while shouting Eureka after discovering the principle of displacement?",
                "Archimedes",
                "Euclid",
                "Homer",
                "Homer",
                1
        )

        questionsList.add(que9)

        val que10 = Questions(10,"medium","What is the Roman numeral for 500?",
                "L",
                "C",
                "X",
                "D",
                4
        )

        questionsList.add(que10)

        return questionsList

    }
}