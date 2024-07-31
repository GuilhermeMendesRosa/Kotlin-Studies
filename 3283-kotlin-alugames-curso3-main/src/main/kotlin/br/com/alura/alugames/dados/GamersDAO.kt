package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager) : DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(gamer: Gamer): GamerEntity {
        return GamerEntity(
            gamer.nome,
            gamer.email,
            gamer.dataNascimento,
            gamer.usuario,
            gamer.id,
            gamer.plano.toEntity()
        )
    }

    override fun toModel(gamerEntity: GamerEntity): Gamer {
        return Gamer(
            gamerEntity.nome,
            gamerEntity.email,
            gamerEntity.dataNascimento,
            gamerEntity.usuario,
            gamerEntity.id
        ).apply { plano = gamerEntity.plano.toModel() }
    }
}
