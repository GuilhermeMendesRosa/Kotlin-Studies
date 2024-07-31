package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager) : DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(jogo: Jogo): JogoEntity {
        return jogo.toEntity()
    }

    override fun toModel(jogoEntity: JogoEntity): Jogo {
        return jogoEntity.toModel()
    }

}
