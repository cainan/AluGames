package br.com.cso.alugames.model

data class Game(val title: String, val cover: String) {
    var description: String? = null

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Descricao: $description"

    }
}