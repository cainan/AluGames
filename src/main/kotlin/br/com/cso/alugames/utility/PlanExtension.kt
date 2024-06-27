package br.com.cso.alugames.utility

import br.com.cso.alugames.datadb.entity.PlanEntity
import br.com.cso.alugames.datadb.entity.SeparatePlanEntity
import br.com.cso.alugames.datadb.entity.SignaturePlanEntity
import br.com.cso.alugames.model.Plan
import br.com.cso.alugames.model.SeparatePlan
import br.com.cso.alugames.model.SignaturePlan

fun Plan.toEntity(): PlanEntity {
    return if (this is SignaturePlan) {
        SignaturePlanEntity(
            type = this.type,
            id = this.id,
            monthlyPrice = this.monthlyPrice,
            gamesIncluded = this.gamesIncluded,
            discount = this.discountPercentage,
        )
    } else {
        SeparatePlanEntity(type = this.type, id = this.id)
    }
}

fun PlanEntity.toModel(): Plan {
    return if (this is SignaturePlanEntity) {
        SignaturePlan(
            type = this.type,
            id = this.id,
            monthlyPrice = this.monthlyPrice,
            gamesIncluded = this.gamesIncluded,
            discountPercentage = this.discount,
        )
    } else {
        SeparatePlan(type = this.type, id = this.id)
    }
}