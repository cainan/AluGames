package br.com.cso.alugames.datadb.dao

import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(private val manager: EntityManager, private val entityType: Class<TEntity>) {

    abstract fun toEntity(data: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    open fun getList(): List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { entity ->
            toModel(entity)
        }
    }

    open fun add(data: TModel) {
        val entity = toEntity(data)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun getById(id: Int): TModel {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE ID = :id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        return toModel(entity)
    }

    open fun remove(id: Int) {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE ID = :id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }


}