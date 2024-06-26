package br.com.cso.alugames.datadb.dao

import br.com.cso.alugames.datadb.entity.PlanEntity
import br.com.cso.alugames.datadb.entity.SeparatePlanEntity
import br.com.cso.alugames.datadb.entity.SignaturePlanEntity
import br.com.cso.alugames.model.Plan
import br.com.cso.alugames.model.SeparatePlan
import br.com.cso.alugames.model.SignaturePlan
import javax.persistence.EntityManager

class PlanDAO(manager: EntityManager) : DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(plan: Plan): PlanEntity {
        return if (plan is SignaturePlan) {
            SignaturePlanEntity(
                type = plan.type,
                id = plan.id,
                monthlyPrice = plan.monthlyPrice,
                gamesIncluded = plan.gamesIncluded,
                discount = plan.discountPercentage,
            )
        } else {
            SeparatePlanEntity(type = plan.type, id = plan.id)
        }
    }

    override fun toModel(entity: PlanEntity): Plan {
        return if (entity is SignaturePlanEntity) {
            SignaturePlan(
                type = entity.type,
                id = entity.id,
                monthlyPrice = entity.monthlyPrice,
                gamesIncluded = entity.gamesIncluded,
                discountPercentage = entity.discount,
            )
        } else {
            SeparatePlan(type = entity.type, id = entity.id)
        }
    }
}