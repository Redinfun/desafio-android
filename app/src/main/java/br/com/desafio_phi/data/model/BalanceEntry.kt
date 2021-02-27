package br.com.desafio_phi.data.model

import com.google.gson.annotations.SerializedName

data class BalanceEntry(
    @SerializedName("amount")
    val amountBalance: Double = 0.00
)