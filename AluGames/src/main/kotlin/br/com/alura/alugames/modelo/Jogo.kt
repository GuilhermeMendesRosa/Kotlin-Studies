package br.com.alura.alugames.modelo

data class Jogo(val titulo: String?, val capa: String?) {
    var descricao: String? = ""

    override fun toString(): String {
        return "Meu br.com.alura.alugames.modelo.Jogo: Título = $titulo - Capa = $capa -  Descrição = $descricao"
    }

}