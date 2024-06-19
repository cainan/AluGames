package br.com.cso.alugames

import br.com.cso.alugames.datadb.Database
import br.com.cso.alugames.datadb.dao.GameDAO
import br.com.cso.alugames.datadb.dao.GamerDAO
import br.com.cso.alugames.model.Game
import br.com.cso.alugames.model.Gamer

fun main() {
//    val db = Database.getConnection()
//    println(db)

    val gameToSave = Game("GoT", "CoverGoT", 99.99, "Ghost Of t")
    val manager = Database.getEntityManager()
    val gameDAO = GameDAO(manager)
//    gameDAO.saveGame(gameToSave)

    val gameList: List<Game> = gameDAO.getGames()
    println(gameList)


    println("-------")
    val gamerToSave = Gamer(name = "GamerTeste", email = "cs@gm.cm", birth = "23/10/2000", username = "userTeste")
    val gamerDAO = GamerDAO(manager)
    gamerDAO.saveGamer(gamerToSave)

    val gamerList: List<Gamer> = gamerDAO.getGamers()
    println(gamerList)

    manager.close()
}