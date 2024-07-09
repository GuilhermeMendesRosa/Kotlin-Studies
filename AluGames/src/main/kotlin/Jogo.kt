data class Jogo(val titulo: String, val capa: String) {
    var descricao: String? = ""

    override fun toString(): String {
        return "Meu Jogo: Título = $titulo - Capa = $capa -  Descrição = $descricao"
    }

}
