package br.com.cso.alugames

import br.com.cso.alugames.datadb.Database
import br.com.cso.alugames.model.Game

fun main() {
    val db = Database.getConnection()
    println(db)


    val gameList: List<Game> = Database.getGames()
    println(gameList)
}