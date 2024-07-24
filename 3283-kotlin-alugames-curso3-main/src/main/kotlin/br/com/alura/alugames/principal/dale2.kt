package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Jogo

fun main() {
    var manager = Banco.getEntityManager()
    var jogosDAO = JogosDAO(manager)
    val jogo = Jogo(
        "Euro Truck",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        0.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    jogosDAO.adicionarJogo(jogo)

    val listaJogos: List<Jogo> = jogosDAO.getJogos()
    println(listaJogos)


    manager.close()
}
