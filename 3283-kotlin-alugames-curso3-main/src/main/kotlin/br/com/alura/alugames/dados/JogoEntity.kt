package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "jogos")
open class JogoEntity(
    val titulo: String = "Título do Jogo",
    val capa: String = "Capa do Jogo",
    val preco: Double = 0.0,
    val descricao: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
}
