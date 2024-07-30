package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager) : DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(jogo: Jogo): JogoEntity {
        return JogoEntity(jogo.titulo, jogo.capa, jogo.preco, jogo.descricao)
    }

    override fun toModel(jogoEntity: JogoEntity): Jogo {
        return Jogo(
            jogoEntity.titulo,
            jogoEntity.capa,
            jogoEntity.preco,
            jogoEntity.descricao,
            jogoEntity.id
        )
    }

    override fun getLista(): List<Jogo> {
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { jogoEntity ->
            Jogo(
                jogoEntity.titulo,
                jogoEntity.capa,
                jogoEntity.preco,
                jogoEntity.descricao,
                jogoEntity.id
            )
        }
    }


}
