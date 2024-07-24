package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

class GamerDAO(val manager: EntityManager) {
    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { gamerEntity ->
            Gamer(
                gamerEntity.nome,
                gamerEntity.email,
                gamerEntity.dataNascimento,
                gamerEntity.usuario,
                gamerEntity.id
            )
        }
    }
}
