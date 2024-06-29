package br.com.cso.alugames.utility

import br.com.cso.alugames.datadb.entity.GameEntity
import br.com.cso.alugames.model.Game

fun Game.toEntity() : GameEntity {
    return GameEntity(
        id = this.id,
        cover = this.cover,
        description = this.description ?: "",
        price = this.price,
        title = this.title
    )
}

fun GameEntity.toModel() : Game {
    return Game(
        id = this.id,
        cover = this.cover,
        description = this.description ?: "",
        price = this.price,
        title = this.title
    )
}