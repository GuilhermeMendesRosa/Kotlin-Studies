import com.google.gson.annotations.SerializedName

class Jogo(
    @SerializedName("title") val titulo: String,
    @SerializedName("thumb") val capa: String
) {
    val descricao = ""

    override fun toString(): String {
        return "Meu Jogo: Título = $titulo - Capa = $capa -  Descrição = $descricao"
    }

}
