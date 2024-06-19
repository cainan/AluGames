package br.com.cso.alugames.datadb.dao

import br.com.cso.alugames.datadb.entity.GamerEntity
import br.com.cso.alugames.model.Gamer
import javax.persistence.EntityManager


class GamerDAO(val manager: EntityManager) {

    fun saveGamer(gamerToSave: Gamer) {
        val entity = GamerEntity(
            name = gamerToSave.name,
            email = gamerToSave.email,
            birth = gamerToSave.birth ?: "",
            username = gamerToSave.username ?: ""
        )
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map {
            Gamer(
                name = it.name,
                email = it.email,
                birth = it.birth,
                username = it.username,
                id = it.id
            )
        }
    }
}