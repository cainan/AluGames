package br.com.cso.alugames.model

abstract class Plan(val type: String) {

    open fun calculatePrice(rent: Rent): Double {
        return rent.game.price * rent.period.inDays
    }

}
