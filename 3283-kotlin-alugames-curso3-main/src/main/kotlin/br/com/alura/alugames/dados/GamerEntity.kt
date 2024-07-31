package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "gamers")
open class GamerEntity(
    var nome: String = "Nome do Gamer",
    var email: String = "email@email.com",
    val dataNascimento: String? = null,
    val usuario: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @ManyToOne
    val plano: PlanoEntity = PlanoAvulsoEntity()
) {
}
