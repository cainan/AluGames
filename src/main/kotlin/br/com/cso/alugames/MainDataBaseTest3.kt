package br.com.cso.alugames

import br.com.cso.alugames.datadb.Database
import br.com.cso.alugames.datadb.dao.GamerDAO
import br.com.cso.alugames.datadb.dao.PlanDAO
import br.com.cso.alugames.model.Gamer


fun main(){
    val manager = Database.getEntityManager()

    val gamer = Gamer("Monica22", "monica2@email.com", "15/03/1995", "moni")

    val gamerDAO = GamerDAO(manager)
    val planDAO = PlanDAO(manager)

    gamer.plan = planDAO.getById(1)

//    gamerDAO.add(gamer)

    val gamerList = gamerDAO.getList()
    println(gamerList)

    manager.close()
}
