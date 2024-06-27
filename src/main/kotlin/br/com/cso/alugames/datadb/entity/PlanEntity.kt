package br.com.cso.alugames.datadb.entity

import javax.persistence.*

@Entity
@Table(name = "plans")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "planType", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(open val type: String = "",
                        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                        open var id : Int = 0,)

@Entity
@DiscriminatorValue(value = "plan")
class SeparatePlanEntity(type: String = "Separate Plan", id: Int = 0) : PlanEntity(type, id)


@Entity
@DiscriminatorValue(value = "signed")
class SignaturePlanEntity(
    type: String = "Signature Plan",
    id : Int = 0,
    val monthlyPrice: Double = 0.0,
    val gamesIncluded: Int = 0,
    val discount: Double = 0.0
) : PlanEntity(type, id)