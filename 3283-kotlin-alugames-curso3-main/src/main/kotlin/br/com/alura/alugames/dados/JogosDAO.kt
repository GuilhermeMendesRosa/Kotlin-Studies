package br.com.alura.alugames.dados

import br.com.alura.alugames.dados.Banco.obterConexao
import br.com.alura.alugames.modelo.Jogo

class JogosDAO {
    fun getJogos(): List<Jogo> {
        val listaJogos = mutableListOf<Jogo>()
        val conexao = obterConexao()

        if (conexao == null) {
            return mutableListOf()
        }

        try {
            val statement = conexao.createStatement()
            var resultado = statement.executeQuery("select * from jogos")
            while (resultado.next()) {
                val id = resultado.getInt("id")
                val capa = resultado.getString("capa")
                val descricao = resultado.getString("descricao")
                val preco = resultado.getDouble("preco")
                val titulo = resultado.getString("titulo")

                var jogo = Jogo(titulo, capa, preco, descricao, id)
                listaJogos.add(jogo)
            }
        } finally {
            conexao.close()
        }

        return listaJogos
    }

    fun adicionarJogo(jogo: Jogo) {
        val conexao = Banco.obterConexao()
        val insert = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"

        if (conexao == null) {
            return
        }

        try {
            val statement = conexao.prepareStatement(insert)
            statement.setString(1, jogo.titulo)
            statement.setString(2, jogo.capa)
            statement.setDouble(3, jogo.preco)
            statement.setString(4, jogo.descricao)

            statement.executeUpdate()
            statement.close()
        } finally {
            conexao.close()
        }
    }
}
