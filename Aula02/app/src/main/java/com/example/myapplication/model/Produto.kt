package com.example.myapplication.model

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class Produto (
    val id: Int,
    val nome: String,
    val preco: Double,
    var estoque: Int
) {

    @Composable
    fun ExibeDetalhes() {
        Text("#$id - $nome - $preco - $estoque")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProduto() {
    val p = Produto(1, "Mouse", 1.1, 10)
    p.ExibeDetalhes()
}