package br.com.cso.alugames

import br.com.cso.alugames.datadb.Database
import br.com.cso.alugames.datadb.dao.GameDAO
import br.com.cso.alugames.model.Game

fun main() {
//    val db = Database.getConnection()
//    println(db)

    val gameToSave = Game("GoT", "CoverGoT", 99.99, "Ghost Of t")
    val manager = Database.getEntityManager()
    val gameDAO = GameDAO(manager)
    gameDAO.saveGame(gameToSave)

    val gameList: List<Game> = gameDAO.getGames()
    println(gameList)

    manager.close()
}