package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.CarrinhoDeCompras
import com.example.myapplication.model.Cliente
import com.example.myapplication.model.Loja
import com.example.myapplication.model.Produto
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // O SOFTWARE COMEÇA AQUI


        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val produto1 = Produto(1, "Notebook", 4500.0, 5)
                val produto2 = Produto(2, "Mouse Gamer", 250.0, 10)

                // Criando cliente
                val cliente = Cliente(1, "Ana", 5000.0)

                // Criando carrinho e loja
                val carrinho = CarrinhoDeCompras()
                val loja = Loja(listOf(produto1, produto2))

                // Adicionando produtos ao carrinho
                carrinho.adicionarProduto(produto1, 1)
                carrinho.adicionarProduto(produto2, 2)

                Column (modifier = Modifier.padding(top = 80.dp)) {

                    // Exibindo o carrinho
                    carrinho.ExibirCarrinho()

                    // Tentando finalizar a compra
                    loja.FinalizarCompra(cliente, carrinho)
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//
//    Column {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier
//        )
//        Text("Olá 1")
//        Text("Olá 2")
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Greeting("Juliano")
//    }
//}