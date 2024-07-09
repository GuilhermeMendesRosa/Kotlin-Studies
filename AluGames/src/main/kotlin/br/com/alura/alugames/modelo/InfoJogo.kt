package br.com.alura.alugames.modelo

data class InfoJogo(val info: InfoAPIShark?) {

    override fun toString(): String {
        return info.toString()
    }
}
