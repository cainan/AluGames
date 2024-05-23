package br.com.cso.alugames.services.model

data class GameInfo(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}