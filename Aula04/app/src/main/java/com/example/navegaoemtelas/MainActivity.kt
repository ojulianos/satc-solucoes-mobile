package com.example.navegaoemtelas
// PROJETO CAÇA AO TESOURO
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navCtrl = rememberNavController()

            NavHost(navController = navCtrl, startDestination = "idTela01") {

                composable ("idTela01") {
                    Tela(
                        "Tela 01",
                        clickB1 = { navCtrl.navigate("idTela02") },
                        clickB2 = { navCtrl.navigate("idTela03") }
                    )
                }
                composable ("idTela02") {
                    Tela("Tela 02",
                        clickB1 = { navCtrl.navigate("idTela01") },
                        clickB2 = { navCtrl.navigate("idTela03") }
                    )
                }
                composable ("idTela03") {
                    Tela("Tela 03",
                        clickB1 = { navCtrl.navigate("idTela02") },
                        clickB2 = { navCtrl.navigate("idTela04") }
                    )
                }
                composable ("idTela04") {
                    Tela("Tela 04",
                        clickB1 = { navCtrl.navigate("idTela03") },
                        clickB2 = { navCtrl.navigate("idTela01") }
                    )
                }
            }
        }
    }
}

@Composable
fun Tela(
    nomeTela: String,
    clickB1: () -> Unit,
    clickB2: () -> Unit
         ) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = nomeTela)
        Button(onClick = clickB1) { Text("B1") }
        Button(onClick = clickB2) { Text("B2") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tela("Inicio",
        clickB1 = { },
        clickB2 = {  }
    )
}