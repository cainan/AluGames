package br.com.cso.alugames.model

import java.time.LocalDate

class SignaturePlan(type: String, val monthlyPrice: Double, val gamesIncluded: Int) : Plan(type) {

    override fun calculatePrice(rent: Rent): Double {
        val totalMonthlyGames = rent.gamer.getGamesRentedInMonth(LocalDate.now().monthValue) + 1
        return if (totalMonthlyGames.size <= gamesIncluded) {
            0.0
        } else {
            super.calculatePrice(rent)
        }
    }

}
