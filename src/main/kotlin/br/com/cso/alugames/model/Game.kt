package br.com.cso.alugames.model

data class Game(val title: String, val cover: String, val price: Double = 0.0) {
    var description: String? = null

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Descricao: $description \n"+
                "Preço: $price"

    }
}