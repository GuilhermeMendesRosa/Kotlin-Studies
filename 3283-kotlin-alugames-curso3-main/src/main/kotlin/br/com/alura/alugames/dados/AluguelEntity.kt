package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Periodo
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "aluguel")
open class AluguelEntity(
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne(cascade = [CascadeType.PERSIST]) val jogo: JogoEntity = JogoEntity(),
    @Embedded
    val periodo: Periodo = Periodo(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
) {
    var valorDoAluguel = 0.0
}
