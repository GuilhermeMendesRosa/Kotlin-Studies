package br.com.alura.alugames.dados

import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(protected val manager: EntityManager, protected val entityTYpe: Class<TEntity>) {

    abstract fun toEntity(objeto: TModel): TEntity
    abstract fun toModel(objeto: TEntity): TModel

    open fun getLista(): List<TModel> {
        val query = manager.createQuery("FROM ${entityTYpe.simpleName}", entityTYpe)
        return query.resultList.map { entity ->
            toModel(entity)
        }
    }

    open fun adicionar(objeto: TModel) {
        val entity = toEntity(objeto)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}
