package br.com.cso.alugames.model

interface Recommendable {
    val average: Double
    fun recommend(grade: Int)
}