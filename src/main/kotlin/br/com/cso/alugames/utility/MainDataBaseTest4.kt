package br.com.cso.alugames.utility

import br.com.cso.alugames.datadb.Database
import br.com.cso.alugames.datadb.dao.GameDAO
import br.com.cso.alugames.datadb.dao.GamerDAO
import br.com.cso.alugames.datadb.dao.RentDAO
import br.com.cso.alugames.model.RentPeriod

fun main() {
    val manager = Database.getEntityManager()
    val gameDAO = GameDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val rentDAO = RentDAO(manager)

    val gamer = gamerDAO.getById(3)
    val game = gameDAO.getById(4)
    val rent = gamer.rentAGame(game, RentPeriod())

    rentDAO.add(rent)


    val rentList = rentDAO.getList()
    println(rentList)

    manager.close()
}