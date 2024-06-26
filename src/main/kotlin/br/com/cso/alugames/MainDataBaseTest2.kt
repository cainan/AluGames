package br.com.cso.alugames

import br.com.cso.alugames.datadb.Database
import br.com.cso.alugames.datadb.dao.PlanDAO
import br.com.cso.alugames.model.SeparatePlan
import br.com.cso.alugames.model.SignaturePlan

fun main () {
    val free = SeparatePlan("BRONZE")
    val silver = SignaturePlan("PRATA", 9.90, 3, 0.15)
    val gold = SignaturePlan("OURO", 19.90, 5, 0.20)
    val platinum = SignaturePlan("PLATINA", 29.90, 10, 0.30)
    val diamond = SignaturePlan("DIAMANTE", 49.90, 20, 0.50)

    val manager = Database.getEntityManager()
    val planDAO = PlanDAO(manager)

    planDAO.add(free)
    planDAO.add(silver)
    planDAO.add(gold)
    planDAO.add(platinum)
    planDAO.add(diamond)

    val planList = planDAO.getList()
    println(planList)

    manager.close()
}