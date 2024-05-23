package br.com.cso.alugames.model

import java.time.LocalDate
import java.time.Period

data class RentPeriod(
    val startDate: LocalDate,
    val endDate: LocalDate
) {
    val inDays = Period.between(startDate, endDate).days
}
