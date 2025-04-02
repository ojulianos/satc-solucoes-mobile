package com.example.caaaotesouto

class QuestionOption(
    val screenId: String,
    val questionText: String,
    val correctAnswer: String,
    val options: List<String>
) {
    fun getImage(): Int {
        return when (this.screenId) {
            "quest_screen_02" -> R.drawable.vaca
            "quest_screen_03" -> R.drawable.estrela
            "start" -> R.drawable.start
            "end" -> R.drawable.end
            else -> R.drawable.google
        }
    }
}