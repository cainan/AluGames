package br.com.cso.alugames.model

data class Rent(val gamer: Gamer, val game: Game, val period: RentPeriod) {

    val rentPrice = game.price * period.inDays

    override fun toString(): String {
        return "${gamer.name} has rented ${game.title} per R$$rentPrice )"
    }
}
