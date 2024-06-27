package br.com.cso.alugames.datadb.dao

import br.com.cso.alugames.datadb.entity.GamerEntity
import br.com.cso.alugames.model.Gamer
import br.com.cso.alugames.utility.toEntity
import br.com.cso.alugames.utility.toModel
import javax.persistence.EntityManager


class GamerDAO(manager: EntityManager) : DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(data: Gamer): GamerEntity {
        return GamerEntity(
            name = data.name,
            email = data.email,
            birth = data.birth ?: "",
            username = data.username ?: "",
            plan = data.plan.toEntity()
        )
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(
            name = entity.name,
            email = entity.email,
            birth = entity.birth,
            username = entity.username,
            id = entity.id,
        ).apply { plan = entity.plan.toModel() }
    }
}