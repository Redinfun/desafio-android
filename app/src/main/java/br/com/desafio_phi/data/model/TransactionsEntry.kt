package br.com.desafio_phi.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


@Parcelize
data class TransactionsEntry(
    @SerializedName("amount")
    val amount: Double = 0.00,
    @SerializedName("id")
    val id: String? = "0",
    @SerializedName("authentication")
    val authentication: String = "",
    @SerializedName("tType")
    val tType: String? = "",
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("to")
    val sendBy: String? = "",
    @SerializedName("description")
    val description: String? = ""
) : Serializable