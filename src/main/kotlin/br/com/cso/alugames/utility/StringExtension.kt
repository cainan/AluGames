package br.com.cso.alugames.utility

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.convertIntoYearsOld() : Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy" )
    var yearsOld = 0
    val birthday = LocalDate.parse(this, formatter)
    val today = LocalDate.now()
    yearsOld = Period.between(birthday,today).years
    return yearsOld
}