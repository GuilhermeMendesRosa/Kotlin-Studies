package br.com.alura.alugames.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val dataInicial: LocalDate,
    val dataFInal: LocalDate
) {
    val valorDoAluguel = jogo.preco * Period.between(dataInicial, dataFInal).days

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} pelo ${gamer.nome} pelo valor do $valorDoAluguel"
    }
}
