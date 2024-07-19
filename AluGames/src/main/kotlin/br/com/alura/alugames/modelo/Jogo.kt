package br.com.alura.alugames.modelo

import com.google.gson.annotations.Expose

data class Jogo(@Expose val titulo: String?, @Expose val capa: String?) : Recomendavel {
    var descricao: String? = ""
    var preco: Double = 0.0
    var notas = mutableListOf<Int>()
    override val media: Double
        get() = notas.average()

    override fun recomendar(nota: Int) {
        if (notas == null) {
            this.notas = mutableListOf()
        }
        notas.add(nota)
    }

    override fun toString(): String {
        return "Meu br.com.alura.alugames.modelo.Jogo: Título = $titulo - Capa = $capa -  Descrição = $descricao"
    }

}
