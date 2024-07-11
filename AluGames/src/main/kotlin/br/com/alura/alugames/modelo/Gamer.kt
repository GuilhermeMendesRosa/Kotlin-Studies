package br.com.alura.alugames.modelo

import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var idInterno: String? = null
        private set

    init {
        validarEmail()

        if (nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome não pode ser vazio")
        }
    }

    constructor(nome: String, email: String, dataNascimento: String, usuario: String) :
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

    override fun toString(): String {
        return "Gamer(" + nome + ", " + email + "," + idInterno + ")"
    }

    fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        var tag = String.format("%04d", numero)
        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        }

        throw IllegalArgumentException("Email inválido")
    }

}
