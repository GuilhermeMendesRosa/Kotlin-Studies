package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamersDAO
import br.com.alura.alugames.dados.PlanosDAO
import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val gamersDAO = GamersDAO(manager)
    val planosDAO = PlanosDAO(manager)

    gamer.plano = planosDAO.recuperarPeloId(3)

    gamersDAO.adicionar(gamer)

    val listaGamersBanco = gamersDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}
