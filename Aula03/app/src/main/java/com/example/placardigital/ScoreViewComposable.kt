package com.example.placardigital

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TeamScore(
    score: Score
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = score.teamName
        )
        Button(onClick = { score.teamScore += 1 }) {
            Text(text = "+")
        }
        Text(
            modifier = Modifier.padding(16.dp),
            text = "${score.teamScore}"
        )
        Button(onClick = { score.teamScore -= 1 }) {
            Text(text = "-")
        }
    }
}

@Composable
fun ScoreView(time1: Score, time2: Score) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TeamScore(time1)
            TeamScore(time2)
        }
    }
}



@Composable
@Preview(showBackground = true)
fun TesteScore() {
    var time1 = Score("Time 1", 5)
    var time2 = Score("Time 2", 0)
    ScoreView(time1, time2)
}