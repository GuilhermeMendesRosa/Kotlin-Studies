package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import javax.persistence.EntityManager

class GamerDAO(manager: EntityManager) : DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(gamer: Gamer): GamerEntity {
        return GamerEntity(gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario)
    }

    override fun toModel(gamerEntity: GamerEntity): Gamer {
        return Gamer(gamerEntity.nome, gamerEntity.email, gamerEntity.dataNascimento, gamerEntity.usuario)

    }
}
