package br.com.cso.alugames.model

import java.util.*
import kotlin.random.Random

data class Gamer(
    var name: String,
    var email: String,
) {

    // it runs before create the object
    init {
        email = validateEmail()
        if (name.isBlank()) {
            throw IllegalArgumentException("Name is invalid")
        }
    }

    var birth: String? = null
    var username: String? = null
        set(value) {
            field = value
            if (identifier.isNullOrBlank()) {
                createIdentifier()
            }
        }
    var identifier: String? = null
        private set

    val searchedGames = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rent>()
    var plan: Plan = SeparatePlan("BRONZE")


    constructor(name: String, email: String, birth: String, username: String) : this(name, email) {
        this.birth = birth
        this.username = username
        createIdentifier()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birth=$birth, username=$username, identifier=$identifier)"
    }

    private fun createIdentifier() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        identifier = "$username#$tag"
    }

    private fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email is not valid")
        }
    }

    fun rentAGame(game: Game, period: RentPeriod): Rent {
        return Rent(this, game, period).also { rentedGames.add(it) }
    }

    fun getGamesRentedInMonth(month: Int): List<Game> {
        return rentedGames.filter { it.period.startDate.monthValue == month }.map { rent -> rent.game }
    }

    fun getGamesRented(): List<Rent> {
        return rentedGames
    }

    companion object {
        fun createGamer(scan: Scanner): Gamer {
            println("Welcome to AluGames! Let's create your profile. Enter your name:")
            val name = scan.nextLine()
            println("Enter your email:")
            val email = scan.nextLine()
            println("Do you want to complete your profile with username and date of birth? (Y/N)")
            val option = scan.nextLine()
            return if (option.equals("y", true)) {
                println("Enter your birthdate (DD/MM/YYYY):")
                val birthdate = scan.nextLine()
                println("Enter your username:")
                val username = scan.nextLine()
                Gamer(name, email, birthdate, username)
            } else {
                Gamer(name, email)
            }
        }
    }
}

fun main() {
    val gamer1 = Gamer(name = "gamer1", "gamer1@gmail.com")
    println(gamer1)

    val gamer2 = Gamer(
        "User2",
        "user2@hotmail.com",
        "23/11/11",
        "theuser2name",
    )
    println(gamer2)

    gamer1.let {
        it.birth = "12/12/2000"
        it.username = "gamer1Id"
        println(it)
    }.also {
        println("Identifier: ${gamer1.identifier}")
    }

    gamer1.username = "Changed"
    println("Final: $gamer1")
}