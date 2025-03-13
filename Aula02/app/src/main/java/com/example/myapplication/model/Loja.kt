package com.example.myapplication.model

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Loja(
    val produtos: List<Produto>
) {
    @Composable
    fun ListarProdutos() {
        Column {
            Text("Produtos da Loja:")

            produtos.forEach{
                if (it.estoque > 0)
                    it.ExibeDetalhes()
            }
        }
    }

    @Composable
    fun FinalizarCompra(cliente: Cliente, carrinho: CarrinhoDeCompras) {
        val total = carrinho.calcularTotal()
        if (cliente.saldo < total) {
            Text("Saldo insuficiente:")
        }

        cliente.saldo -= total
        produtos.forEach { it.estoque -= 1 }

        Text("Compra Finalizada!")
    }
}