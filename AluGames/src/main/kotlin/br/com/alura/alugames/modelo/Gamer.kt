package br.com.alura.alugames.modelo

import java.time.LocalDate
import java.util.*
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
    val jogosBuscados = mutableListOf<Jogo?>()

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

    fun alugaJogo(jogo: Jogo, dataInicial: LocalDate, dataFinal: LocalDate): Aluguel {
        return Aluguel(this, jogo, dataInicial, dataFinal)
    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (!opcao.equals("s", true)) {
                return Gamer(nome, email)
            }

            println("Digite sua data de nascimento(DD/MM/AAAA):")
            val nascimento = leitura.nextLine()
            println("Digite seu nome de usuário:")
            val usuario = leitura.nextLine()

            return Gamer(nome, email, nascimento, usuario)
        }
    }

}
