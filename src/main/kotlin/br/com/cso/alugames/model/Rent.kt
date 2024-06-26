package br.com.cso.alugames.model

data class Rent(val gamer: Gamer, val game: Game, val period: RentPeriod) {

    val rentPrice = gamer.plan.calculatePrice(this)
    var id = 0

    override fun toString(): String {
        return "${gamer.name} has rented ${game.title} per R$$rentPrice )"
    }
}
