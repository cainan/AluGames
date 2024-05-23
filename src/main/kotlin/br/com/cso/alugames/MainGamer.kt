package br.com.cso.alugames

import br.com.cso.alugames.model.RentPeriod
import br.com.cso.alugames.services.SharkApi
import java.time.LocalDate

fun main() {
    val sharkApi = SharkApi()
    val listGamers = sharkApi.listGamers()
    val listGames = sharkApi.listGames()

//    println(listGamers)
//    println(listGames)

    val gamer = listGamers[1]
    val game = listGames[1]
    val rented = gamer.rentAGame(game, RentPeriod(LocalDate.now(), LocalDate.now().plusDays(2L)))

    println(gamer)
    println(game)
    println(rented)

    gamer.rentAGame(listGames[2], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(3L)))
    gamer.rentAGame(listGames[3], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(4L)))

    println()
    println()
    gamer.rentedGames.forEach {
        println(it)
    }

}