package com.example.myapplication.model

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class CarrinhoDeCompras {
    val listaItens = mutableListOf<Produto>()

    fun adicionarProduto(p: Produto, qtd: Int) {
        for (i in 1..qtd) {
            listaItens.add(p)
        }
    }

    fun removerProduto(p: Produto) {
        listaItens.remove(p);
    }

    fun calcularTotal(): Double {
        var total: Double = 0.0
        listaItens.forEach{ total += it.preco }
        return total
    }

    @Composable
    fun ExibirCarrinho() {
        Column {
            Text("Carrinho de Compras")

            listaItens.forEach{ it.ExibeDetalhes() }
        }
    }
}