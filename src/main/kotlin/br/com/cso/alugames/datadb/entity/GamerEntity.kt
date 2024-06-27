package br.com.cso.alugames.datadb.entity

import javax.persistence.*

@Entity
@Table(name = "gamer")
class GamerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "nome")
    val name: String = "",

    @Column(name = "email")
    val email: String = "",

    @Column(name = "nascimento")
    val birth: String = "",

    @Column(name = "usuario")
    val username: String = "",

    @ManyToOne
    val plan: PlanEntity = SeparatePlanEntity(),
)