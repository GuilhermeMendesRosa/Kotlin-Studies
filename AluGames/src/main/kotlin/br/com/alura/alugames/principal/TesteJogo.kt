package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoAPI

fun main() {
    val consumo = ConsumoAPI()
    var listaGamers = consumo.buscaGamers()

    println(listaGamers)
}
