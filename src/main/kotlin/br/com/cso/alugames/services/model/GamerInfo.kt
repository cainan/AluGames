package br.com.cso.alugames.services.model

import br.com.cso.alugames.model.Gamer

data class GamerInfo(
    val nome: String,
    val email: String,
    val dataNascimento: String,
    val usuario: String,
)

fun GamerInfo.convertToGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}