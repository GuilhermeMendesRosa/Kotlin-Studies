package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(
    val tipo: String = "Plano",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
)

@Entity
@DiscriminatorValue("Avulso")
open class PlanoAvulsoEntity(tipo: String = "Plano Assinatura", id: Int = 0) : PlanoEntity(tipo, id)

@Entity
@DiscriminatorValue("Assinatura")
open class PlanoAssinaturaEntity(
    tipo: String = "Plano Assinatura",
    val mensalidade: Double = 0.0,
    val jogosIncluidos: Int = 0,
    val percentualDescontoReputacao: Double= 0.0,
    id: Int = 0,
) : PlanoEntity(tipo, id)
