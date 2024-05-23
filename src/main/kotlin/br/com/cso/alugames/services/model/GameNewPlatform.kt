package br.com.cso.alugames.services.model

import br.com.cso.alugames.model.Game

data class GameNewPlatform(val titulo: String, val capa: String, val preco: Double = 0.0) {
    var descricao: String? = null
}

fun GameNewPlatform.convertToGame(): Game {
    return Game(
        this.titulo,
        this.capa,
        this.preco,
    ).also {
        it.description = this.descricao
    }
}