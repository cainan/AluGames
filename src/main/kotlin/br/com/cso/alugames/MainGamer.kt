package br.com.cso.alugames

import br.com.cso.alugames.model.RentPeriod
import br.com.cso.alugames.model.SignaturePlan
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
    println()

    val newGamer = listGamers[5]
    newGamer.plan = SignaturePlan("PRATA", 9.90, 3)
    newGamer.rentAGame(game, RentPeriod(LocalDate.now(), LocalDate.now().plusDays(2L)))
    newGamer.rentAGame(listGames[2], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(3L)))
    newGamer.rentAGame(listGames[3], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(4L)))
    newGamer.rentAGame(listGames[3], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(4L)))
    newGamer.rentAGame(listGames[3], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(4L)))
    newGamer.rentedGames.forEach {
        println(it)
    }
}