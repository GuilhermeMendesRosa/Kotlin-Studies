package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoAPI
import java.util.*

fun main() {
    var leitura = Scanner(System.`in`)

    println("Digite um código de jogo para buscar: ")
    var id = leitura.nextLine()

    var buscaApi = ConsumoAPI()

    var meuJogo: Jogo? = null;
    var result = runCatching {
        var meuInfoJogo = buscaApi.buscaJogo(id)
        meuJogo = Jogo(meuInfoJogo?.info?.title, meuInfoJogo?.info?.thumb)
    }

    result.onFailure {
        println("br.com.alura.alugames.modelo.Jogo inexistente, Tente outro id.")
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

