package br.com.cso.alugames

import br.com.cso.alugames.datadb.Database
import br.com.cso.alugames.datadb.dao.GameDAO
import br.com.cso.alugames.datadb.dao.GamerDAO
import br.com.cso.alugames.model.Game
import br.com.cso.alugames.model.Gamer

fun main() {
//    val db = Database.getConnection()
//    println(db)

//    val gameToSave = Game("GoT", "CoverGoT", 99.99, "Ghost Of t")
    val manager = Database.getEntityManager()
    val gameDAO = GameDAO(manager)
////    gameDAO.add(gameToSave)

//    val gameList: List<Game> = gameDAO.getList()
//    println(gameList)


//    println("-------")
//    val gamerToSave = Gamer(name = "GamerTeste", email = "cs@gm.cm", birth = "23/10/2000", username = "userTeste")
//    val gamerDAO = GamerDAO(manager)
////    gamerDAO.add(gamerToSave)
//
//    val gamerList: List<Gamer> = gamerDAO.getList()
//    println(gamerList)


    val gameRetrieved = gameDAO.getById(1)
    println(gameRetrieved)

    gameDAO.remove(gameRetrieved.id)

    val gameList2: List<Game> = gameDAO.getList()
    println(gameList2)

    manager.close()
}