package br.com.cso.alugames.datadb

import br.com.cso.alugames.model.Game
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

// object is used to create singleton
object Database {

    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "admin@123")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    fun getGames(): List<Game> {
        TODO("Not yet implemented")
    }


}