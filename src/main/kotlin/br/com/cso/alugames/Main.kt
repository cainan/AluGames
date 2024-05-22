package br.com.cso.alugames

import br.com.cso.alugames.model.Game
import br.com.cso.alugames.model.Gamer
import br.com.cso.alugames.services.SharkApi
import br.com.cso.alugames.utility.convertIntoYearsOld
import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    val gamer = Gamer.createGamer(scan)
    println("Gamer successfully created: $gamer")
    println("Gamer has ${gamer.birth?.convertIntoYearsOld()} years old")


    do {
        println("Add a code to search a game:")
        val code = scan.nextLine()

        val sharkApi = SharkApi()
        val gameInfo = sharkApi.findGame(code)

        var myGame: Game? = null

        val result = runCatching {
            myGame = Game(
                gameInfo.info.title,
                gameInfo.info.thumb
            )
        }

        result.onFailure {
            println("This game not exist. Please try another code")
        }

        result.onSuccess {
            println("Do you want to add a custom description? Y/N")
            val option = scan.nextLine()
            if (option.equals("y", true)) {
                println("Insert the custom description for the game:")
                val customDescription = scan.nextLine()
                myGame?.description = customDescription
            } else {
                myGame?.description = myGame?.title

            }
            gamer.searchedGames.add(myGame)

            println(myGame)
        }

        println("Do you want to search for another game? Y/N")
        val searchAnother = scan.nextLine()

    } while (searchAnother.equals("y", true))

    println("Searched games per ordered by title:")
    gamer.searchedGames.sortBy { it?.title }
    gamer.searchedGames.forEach {
        println("Title: ${it?.title}")
    }

    var filtered = gamer.searchedGames.filter {
        it?.title?.contains("Batman", true) ?: false
    }
    filtered.forEach {
        println("Filtered: ${it?.title}")
    }

    println("Do you want to remove anyone of the original list? Y/N")
    val wantToRemove = scan.nextLine()
    if (wantToRemove.equals("y", true)) {
        println("Qual posição?")
        val index = scan.nextInt()
        gamer.searchedGames.removeAt(index)
    }

    println("Updated list")
    println("${gamer.searchedGames}")

    println("Search end successfully.")

}