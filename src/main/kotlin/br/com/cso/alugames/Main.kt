package br.com.cso.alugames

import br.com.cso.alugames.model.Game
import br.com.cso.alugames.services.SharkApi
import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
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

        println(myGame)
    }

    result.onSuccess {
        println("Search end successfully.")
    }

}