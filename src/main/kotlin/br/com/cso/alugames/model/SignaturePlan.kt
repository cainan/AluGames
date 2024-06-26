package br.com.cso.alugames.model

import java.time.LocalDate

class SignaturePlan(
    type: String,
    val monthlyPrice: Double,
    val gamesIncluded: Int,
    val discountPercentage: Double,
    id: Int = 0
) : Plan(type, id) {

    override fun calculatePrice(rent: Rent): Double {
        val totalMonthlyGames = rent.gamer.getGamesRentedInMonth(LocalDate.now().monthValue) + 1
        return if (totalMonthlyGames.size <= gamesIncluded) {
            0.0
        } else {
            var originalPrice = super.calculatePrice(rent)
            if (rent.gamer.average > 8) {
                originalPrice -= originalPrice * discountPercentage
            }
            originalPrice
        }
    }

}
