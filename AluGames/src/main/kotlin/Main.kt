import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

fun main() {
    var leitura = Scanner(System.`in`)

    println("Digite um código de jogo para buscar: ")
    var busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())


    var meuJogo: Jogo? = null;
    var result = runCatching {
        val json = response.body()
        var meuInfoJogo = Gson().fromJson(json, InfoJogo::class.java)
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    }

    result.onFailure {
        println("Jogo inexistente, Tente outro id.")
    }

    result.onSuccess {
        println("Deseja inserir um descrição personalizada? S/N?")
        var editarDescricao = leitura.nextLine().trim().equals("S", true);

        if (editarDescricao) {
            println("Insira a descrição personalizada do jogo: ")
            var novaDescricao = leitura.nextLine()
            meuJogo?.descricao = novaDescricao

        } else {
            meuJogo?.descricao = meuJogo?.titulo;
        }

        println(meuJogo)
    }

}

