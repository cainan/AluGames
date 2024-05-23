package br.com.cso.alugames.services

import br.com.cso.alugames.model.Game
import br.com.cso.alugames.model.Gamer
import br.com.cso.alugames.services.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class SharkApi {

    fun findGame(id: String): GameInfo {
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = performRequest(address)

        val gson = Gson()
        return gson.fromJson(json, GameInfo::class.java)
    }

    fun listGamers(): List<Gamer> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = performRequest(address)

        val gson = Gson()
        val type = object : TypeToken<List<GamerInfo>>() {}.type
        val gamerListJson: List<GamerInfo> = gson.fromJson(json, type)
        val convertedGamer = gamerListJson.map { gamerInfo ->
            gamerInfo.convertToGamer()
        }

        return convertedGamer
    }


    fun listGames(): List<Game> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = performRequest(address)

        val gson = Gson()
        val type = object : TypeToken<List<GameNewPlatform>>() {}.type
        val gameListJson: List<GameNewPlatform> = gson.fromJson(json, type)
        val game = gameListJson.map { gameJson -> gameJson.convertToGame() }

        return game
    }

    private fun performRequest(address: String): String? {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }

}