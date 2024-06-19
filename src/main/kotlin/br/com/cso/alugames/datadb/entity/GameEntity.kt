package br.com.cso.alugames.datadb.entity

import javax.persistence.*

@Entity
@Table(name = "jogos")
class GameEntity(
    @Column(name = "titulo")
    val title: String = "n/a",

    @Column(name = "capa")
    val cover: String = "n/a",

    @Column(name = "preco")
    val price: Double = 0.0,

    @Column(name = "descricao")
    val description: String = "n/a",

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
)