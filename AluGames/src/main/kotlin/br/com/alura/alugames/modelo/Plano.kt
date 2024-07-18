package br.com.alura.alugames.modelo

open class Plano(val tipo: String) {
    open fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}
