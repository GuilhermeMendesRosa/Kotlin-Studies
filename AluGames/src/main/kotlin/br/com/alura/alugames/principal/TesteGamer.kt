package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Guilherme", "guilherme@email.com")
    println(gamer1)

    gamer1.let {
        it.dataNascimento = "10/04/2003"
        it.usuario = "gui"
    }.also {
        println(gamer1.idInterno)
    }

    val gamer2 = Gamer("Ana Paula", "ana@email.com", "11/02/2005", "aninha")
    println(gamer2)
    println(gamer1)
}
