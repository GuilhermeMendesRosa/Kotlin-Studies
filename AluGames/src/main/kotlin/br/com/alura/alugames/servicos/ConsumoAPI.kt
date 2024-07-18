package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.InfoGamerJSON
import br.com.alura.alugames.modelo.InfoJogo
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.utiliario.toGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoAPI {

    fun buscaJogo(id: String): InfoJogo? {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = doGet(endereco)

        return Gson().fromJson(json, InfoJogo::class.java)
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = doGet(endereco)

        val tipo = object : TypeToken<List<InfoGamerJSON>>() {}.type
        var InfoGamerJSONs: List<InfoGamerJSON> = Gson().fromJson<List<InfoGamerJSON>>(json, tipo)

        var gamers: List<Gamer> = InfoGamerJSONs.map { infoGamer ->
            infoGamer.toGamer()
        }

        return gamers
    }

    fun buscaJogos(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

        val json = doGet(endereco)

        val tipo = object : TypeToken<List<Jogo>>() {}.type
        var jogos: List<Jogo> = Gson().fromJson<List<Jogo>>(json, tipo)

        return jogos
    }

    private fun doGet(endereco: String): String? {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()
        return json
    }

}
