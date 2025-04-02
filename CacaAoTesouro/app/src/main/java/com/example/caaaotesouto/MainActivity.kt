package com.example.caaaotesouto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val quest = Quest()
            val questions = Questions()
            val navCtrl = rememberNavController()

            NavHost(navController = navCtrl, startDestination = "ScreenQuestion0") {

                questions.getQuestions().forEachIndexed { index, currQuestion ->
                    var nextScreen = "ScreenQuestion${index+1}"

                    composable ("ScreenQuestion${index}") {
                        quest.Show(
                            question = currQuestion,
                            clickB1 = {
                                if (index == questions.getQuestions().size - 1) {
                                    navCtrl.popBackStack("ScreenQuestion0", inclusive = false)
                                } else {
                                    navCtrl.navigate(nextScreen)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val quest = Quest()
    val questions = Questions()

    Row {
        questions.getQuestions().forEachIndexed { index, currQuestion ->
            quest.Show(
                question = currQuestion,
                clickB1 = {  }
            )
        }
    }

}