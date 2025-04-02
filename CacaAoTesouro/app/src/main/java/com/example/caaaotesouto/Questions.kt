package com.example.caaaotesouto

class Questions() {
    private val questions = mutableListOf<QuestionOption>()

    init {
        this.addQuestion(
            QuestionOption("start", "Iniciar a caça ao tesouro!", "Iniciar", listOf<String>("Iniciar"))
        )
        this.addQuestion(
            QuestionOption("quest_screen_02", "Qual é o animal que fornece leite e faz 'Mu'?", "Vaca", listOf<String>("Vaca", "Cavalo", "Ovelha"))
        )
        this.addQuestion(
            QuestionOption("quest_screen_03", "Qual é o nome popular dado para as 3 estrelas no cinturão de órion?", "Três Marias", listOf<String>("Três Marias", "Tiazinhas", "Os trapalhões"))
        )
        this.addQuestion(
            QuestionOption("quest_end", "Qual é o site de buscas mais popular do mundo?", "Google", listOf<String>("Google", "Yahoo", "Bing!"))
        )

        this.addQuestion(
            QuestionOption("end", "Parabéns, você finalizou!", "Voltar ao Início", listOf<String>("Voltar ao Início"))
        )
    }

    fun addQuestion(question: QuestionOption) {
        questions.add(question)
    }

    fun getQuestions(): MutableList<QuestionOption> {
        return questions
    }

}