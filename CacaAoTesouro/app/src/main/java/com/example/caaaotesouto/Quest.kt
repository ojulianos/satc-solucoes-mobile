package com.example.caaaotesouto

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Quest {

    @Composable
    fun Show(
        question: QuestionOption,
        clickB1: () -> Unit
    ) {
        val shuffledResponses = question.options.shuffled()

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(question.getImage()),contentDescription = null)
            TextStyle(question.questionText)

            shuffledResponses.forEach { response ->
                if (response == question.correctAnswer) {
                    ButtonStyle(titleBtn = response, clickBtn = clickB1)
                } else {
                    ButtonStyle(titleBtn = response, clickBtn = {})
                }
            }
        }
    }

    @Composable
    private fun ButtonStyle(titleBtn: String, clickBtn: () -> Unit) {
        Button(
            onClick = clickBtn,
            colors = ButtonColors(
                containerColor = Color.Red,
                contentColor = Color.White,
                disabledContentColor = Color.Cyan,
                disabledContainerColor = Color.Cyan
            )
        ) { Text(titleBtn) }
    }

    @Composable
    private fun TextStyle(titleText: String) {
        Text(
            text = titleText,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 18.dp, end = 10.dp, start = 10.dp)
        )
    }
}