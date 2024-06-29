package br.com.cso.alugames.datadb.entity

import br.com.cso.alugames.model.RentPeriod
import javax.persistence.*

@Entity
@Table(name = "rent")
class RentEntity(
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne
    val game: GameEntity = GameEntity(),
    @Embedded
    val period: RentPeriod = RentPeriod(),
    ) {

    var rentValue = 0.0

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}