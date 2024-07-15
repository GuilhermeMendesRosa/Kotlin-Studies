package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoAPI
import transformarEmIdade
import java.util.*

fun main() {
    var leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluído com sucesso. Dados do Gamer: $gamer")

    println("Idade do gamer: ${gamer.dataNascimento?.transformarEmIdade()}")
    do {
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

            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true))

    println("Jogos bucados: ")
    println(gamer.jogosBuscados)

    println()
    println("Jogos ordenados por titulo:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }

    println("Jogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum item da lista original? S/N")
    val opcao = leitura.nextLine()

    if (opcao.equals("s", true)) {
        println(gamer.jogosBuscados)
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\n Lista atualizada: ")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso!")
}

