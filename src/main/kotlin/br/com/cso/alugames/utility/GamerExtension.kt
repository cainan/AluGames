package br.com.cso.alugames.utility

import br.com.cso.alugames.datadb.entity.GamerEntity
import br.com.cso.alugames.model.Gamer

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(
        name = this.name,
        email = this.email,
        birth = this.birth ?: "",
        username = this.username ?: "",
        plan = this.plan.toEntity()
    )
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(
        name = this.name,
        email = this.email,
        birth = this.birth ?: "",
        username = this.username ?: "",
        id = this.id,
    )
}