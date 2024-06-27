package br.com.cso.alugames.datadb.dao

import br.com.cso.alugames.datadb.entity.PlanEntity
import br.com.cso.alugames.model.Plan
import br.com.cso.alugames.utility.toEntity
import br.com.cso.alugames.utility.toModel
import javax.persistence.EntityManager

class PlanDAO(manager: EntityManager) : DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(data: Plan): PlanEntity {
        return data.toEntity()
    }

    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }
}