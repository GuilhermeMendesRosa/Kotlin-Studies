package br.com.alura.alugames.modelo

class PlanoAvulso(tipo: String) : Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): Double {
        var valorOriginal = super.obterValor(aluguel)

        val temDesconto = aluguel.gamer.media > 8
        if (temDesconto) {
            val valorComDesconto = valorOriginal - valorOriginal * 0.1
            return valorComDesconto
        }

        return valorOriginal
    }

}
