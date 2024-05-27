package br.com.cso.alugames.model

class SeparatePlan(type: String, id: Int = 0) : Plan(type, id) {

    override fun calculatePrice(rent: Rent): Double {
        var originalPrice = super.calculatePrice(rent)
        if (rent.gamer.average > 8) {
            originalPrice -= originalPrice * 0.1
        }
        return originalPrice
    }
}

//Ana has rented Grand Theft Auto V per R$5.98 )
//Ana has rented The Last of Us Part I per R$17.97 )
//Ana has rented Red Dead Redemption 2 per R$7.96 )