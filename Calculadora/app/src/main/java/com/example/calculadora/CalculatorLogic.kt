package com.example.calculadora

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.udojava.evalex.Expression

class CalculatorLogic {
    var expression by mutableStateOf("0")

    fun calculate(button: String) {
        expression = when (button) {
            "C" -> "0"
            "=" -> Expression(expression).eval().toString()
            else -> { if (expression == "0") button else expression + button}
        }
    }
}


