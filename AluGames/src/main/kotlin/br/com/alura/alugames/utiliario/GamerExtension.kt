package br.com.alura.alugames.utiliario

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.InfoGamerJSON

fun InfoGamerJSON.toGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}
