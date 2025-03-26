package com.example.placardigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RowsAndColumns()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowsAndColumns() {

    var time1 = Score("Time 1", 5)
    var time2 = Score("Time 2", 0)
    ScoreView(time1, time2)

}