package com.example.calculadora

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButtons(calculatorLogic: CalculatorLogic) {

    val buttons = arrayOf(
        arrayOf("1", "2", "3", "+"),
        arrayOf("4", "5", "6", "-"),
        arrayOf("7", "8", "9", "*"),
        arrayOf("C", "0", "=", "/")
    )

    for (line in buttons) {
        Row {
            for (button in line) {
                Button(
                    onClick = { calculatorLogic.calculate(button) },
                    modifier = Modifier.padding(1.dp)
                ) {
                    Text(text = button)
                }
            }
        }
    }
}

@Composable
fun CalculatorView() {
    val calculatorLogic = remember { CalculatorLogic() }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column (
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = calculatorLogic.expression,
                fontSize = 30.sp,
                modifier = Modifier.padding(top = 86.dp, bottom = 16.dp, end = 10.dp)
            )
            CalculatorButtons(calculatorLogic)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CalculatorPreView(){
    CalculatorView();
}