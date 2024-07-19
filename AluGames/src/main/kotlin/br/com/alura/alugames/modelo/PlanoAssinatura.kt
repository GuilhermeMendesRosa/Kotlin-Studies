package br.com.alura.alugames.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double
) : Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size

        return if (totalJogosNoMes < jogosIncluidos) {
            0.0
        } else {
            var valor = super.obterValor(aluguel)
            if (aluguel.gamer.media > 8) {
                valor -= valor * percentualDescontoReputacao
            }

            valor
        }
    }

}
