package br.com.cso.alugames.datadb.dao

import br.com.cso.alugames.datadb.entity.RentEntity
import br.com.cso.alugames.model.Rent
import br.com.cso.alugames.utility.toEntity
import br.com.cso.alugames.utility.toModel
import javax.persistence.EntityManager

class RentDAO(manager: EntityManager) : DAO<Rent, RentEntity>(manager, RentEntity::class.java) {
    override fun toEntity(data: Rent): RentEntity {
        return RentEntity(data.gamer.toEntity(), data.game.toEntity(), data.period)
            .apply {
                rentValue = data.rentPrice
                id = data.id
            }
    }

    override fun toModel(entity: RentEntity): Rent {
        return Rent(entity.gamer.toModel(), entity.game.toModel(), entity.period)
            .apply {
                id = entity.id
            }
    }
}