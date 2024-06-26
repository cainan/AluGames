package br.com.cso.alugames.model

import com.google.gson.annotations.Expose

data class Game(@Expose val title: String, @Expose val cover: String, val price: Double = 0.0) : Recommendable {
    var description: String? = null
    private val gradeList = mutableListOf<Int>()
    var id = 0
    override val average: Double
        get() = gradeList.average()

    override fun recommend(grade: Int) {
        gradeList.add(grade)
    }

    constructor(title: String, cover: String, price: Double, description: String, id: Int = 0) : this(
        title,
        cover,
        price
    ) {
        this.description = description
        this.id = id
    }

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Descricao: $description \n" +
                "Preço: $price \n" +
                "Id: $id \n" +
                "Avaliação: $average"

    }
}