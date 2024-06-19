package br.com.cso.alugames.datadb.dao

import br.com.cso.alugames.datadb.entity.GameEntity
import br.com.cso.alugames.model.Game
import javax.persistence.EntityManager

class GameDAO(manager: EntityManager) : DAO<Game, GameEntity>(manager, GameEntity::class.java) {
    override fun toEntity(data: Game): GameEntity {
        return GameEntity(
            id = data.id,
            cover = data.cover,
            description = data.description ?: "",
            price = data.price,
            title = data.title
        )
    }

    override fun toModel(entity: GameEntity): Game {
        return Game(
            id = entity.id,
            cover = entity.cover,
            description = entity.description,
            price = entity.price,
            title = entity.title
        )
    }

//    fun getGames(): List<Game> {
//        val listGames = mutableListOf<Game>()
//        val connection = getConnection()
//        connection?.use {
//            val statement = it.createStatement()
//            val result = statement.executeQuery("SELECT * FROM jogos")
//            while (result.next()) {
//                val id = result.getInt("id")
//                val cover = result.getString("capa")
//                val description = result.getString("descricao")
//                val price = result.getDouble("preco")
//                val title = result.getString("titulo")
//
//                val game = Game(id = id, cover = cover, description = description, price = price, title = title)
//                listGames.add(game)
//            }
//            statement.close()
//        }
//
//        return listGames
//    }
//
//    fun saveGame(gameToSave: Game) {
//        val connection = getConnection()
//        val insert = "INSERT INTO jogos (titulo, capa, preco, descricao) VALUES (?, ?, ?, ?)"
//        connection?.use {
//            val statement = it.prepareStatement(insert)
//            statement.setString(1, gameToSave.title)
//            statement.setString(2, gameToSave.cover)
//            statement.setDouble(3, gameToSave.price)
//            statement.setString(4, gameToSave.description)
//            statement.execute()
//            statement.close()
//        }
//    }


}