package com.example.aula07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.aula07.ui.theme.Aula07Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "prod"
            ).allowMainThreadQueries()
            .build()

        var userDao = db.userDao()
        var users by mutableStateOf(userDao.getAll())

        enableEdgeToEdge()
        setContent {
            ContactApp(users) {
                db.userDao().insertAll(it) // grava no db um ovo usuario
                users = db.userDao().getAll()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}