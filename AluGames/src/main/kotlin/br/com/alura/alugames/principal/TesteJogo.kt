package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoAPI
import java.time.LocalDate

fun main() {
    val consumo = ConsumoAPI()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogos()

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogos.get(10)

    val aluguel = gamerCaroline.alugaJogo(jogoResidentVillage, LocalDate.now(), LocalDate.now().plusDays(3))

    print(aluguel)
}
