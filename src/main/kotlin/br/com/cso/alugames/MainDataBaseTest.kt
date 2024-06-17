package br.com.cso.alugames

import br.com.cso.alugames.datadb.Database
import br.com.cso.alugames.datadb.dao.GameDAO
import br.com.cso.alugames.model.Game

fun main() {
    val db = Database.getConnection()
    println(db)

    val gameToSave = Game("TLOU", "CoverTLOU", 100.00, "The Last of Us")
    val gameDAO = GameDAO()
    gameDAO.saveGame(gameToSave)

    val gameList: List<Game> = gameDAO.getGames()
    println(gameList)
}