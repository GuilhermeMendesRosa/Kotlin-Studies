package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.servicos.ConsumoAPI
import java.time.LocalDate

fun main() {
    val consumo = ConsumoAPI()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogos()

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogos.get(10)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val aluguel = gamerCaroline.alugaJogo(jogoResidentVillage, periodo)

    print(aluguel)

    var jogoSpider = listaJogos.get(13)
    var jogoTLOU = listaJogos.get(2)

    gamerCaroline.alugaJogo(jogoSpider, periodo)
    gamerCaroline.alugaJogo(jogoTLOU, periodo)

    println()
    println("Jogos alugados por: ${gamerCaroline.nome}")
    println(gamerCaroline.jogosAlugados)

}
