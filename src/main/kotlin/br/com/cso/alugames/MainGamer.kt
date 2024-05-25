package br.com.cso.alugames

import br.com.cso.alugames.model.RentPeriod
import br.com.cso.alugames.model.SignaturePlan
import br.com.cso.alugames.services.SharkApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val sharkApi = SharkApi()
    val listGamers = sharkApi.listGamers()
    val listGames = sharkApi.listGames()

//    println(listGamers)
//    println(listGames)

    val gameAna = listGamers[1]
    val gameGta = listGames[1]
    val gameTlou = listGames[2]
    val rented = gameAna.rentAGame(gameGta, RentPeriod(LocalDate.now(), LocalDate.now().plusDays(2L)))

    println(gameAna)
    println(gameGta)
    println(rented)

    gameAna.rentAGame(gameTlou, RentPeriod(LocalDate.now(), LocalDate.now().plusDays(3L)))
    gameAna.rentAGame(listGames[3], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(4L)))
    gameAna.recommend(10)
    gameAna.recommend(10)
    gameAna.recommend(8)
    gameAna.rentAGame(listGames[3], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(4L)))

    println()
    println()
    gameAna.rentedGames.forEach {
        println(it)
    }
    println()

    val gamerCamila = listGamers[5]
    gamerCamila.plan = SignaturePlan("PRATA", 9.90, 3, 0.15)
    gamerCamila.rentAGame(gameGta, RentPeriod(LocalDate.now(), LocalDate.now().plusDays(2L)))
    gamerCamila.rentAGame(gameTlou, RentPeriod(LocalDate.now(), LocalDate.now().plusDays(3L)))
    gamerCamila.rentAGame(listGames[3], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(4L)))
    gamerCamila.rentAGame(listGames[3], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(4L)))
    gamerCamila.recommend(10)
    gamerCamila.recommend(10)
    gamerCamila.recommend(8)
    gamerCamila.rentAGame(listGames[3], RentPeriod(LocalDate.now(), LocalDate.now().plusDays(4L)))
    gamerCamila.rentedGames.forEach {
        println(it)
    }

    println(gamerCamila)

//    gamerCamila.recommendGame(gameGta,10)
//    gamerCamila.recommendGame(gameTlou,5)
//
//    gameAna.recommendGame(gameGta,0)
//    gameAna.recommendGame(gameTlou,8)
//
//    gamerCamila.recommendedGames.forEach {
//        println("Camila recomendou ${it.title} - ${it.average}")
//    }
//    gameAna.recommendedGames.forEach {
//        println("Ana recomendou ${it.title} - ${it.average}")
//    }
    println()

    val gamerCaroline = listGamers[3]
    val jogoResidentVillage = listGames[10]
    val jogoSpider = listGames[13]
    val jogoTheLastOfUs = listGames[2]
    val jogoDandara = listGames[5]
    val jogoAssassins = listGames[4]
    val jogoCyber = listGames[6]
    val jogoGod = listGames[7]
    val jogoSkyrim = listGames[18]

    gamerCamila.recommendGame(jogoResidentVillage, 7)
    gamerCamila.recommendGame(jogoTheLastOfUs, 10)
    gamerCamila.recommendGame(jogoAssassins, 8)
    gamerCamila.recommendGame(jogoCyber, 7)
    gamerCamila.recommendGame(jogoGod, 10)
    gamerCamila.recommendGame(jogoDandara, 8)
    gamerCamila.recommendGame(jogoSkyrim, 8)
    gamerCamila.recommendGame(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        .create()
    val serialize = gson.toJson(gamerCamila.recommendedGames)
    println(serialize)

    val file = File("recommendedGames.json")
    file.writeText(serialize)

    println(file.readText())

}

