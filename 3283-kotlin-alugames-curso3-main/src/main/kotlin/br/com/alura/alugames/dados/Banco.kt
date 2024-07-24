package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/alugames", "postgres", "postgres")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

}
