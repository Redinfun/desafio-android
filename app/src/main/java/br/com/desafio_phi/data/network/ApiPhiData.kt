package br.com.desafio_phi.data.network

import br.com.desafio_phi.data.model.BalanceEntry
import br.com.desafio_phi.data.model.StatementEntry
import br.com.desafio_phi.data.model.TransactionsEntry
import br.com.desafio_phi.utils.Constants.Companion.API_KEY

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface ApiPhiData {
    @Headers("token: $API_KEY")
    @GET("myBalance")
     fun getBalance(): Call<BalanceEntry>

    @Headers("token: $API_KEY")
    @GET("myStatement/2000/0")
     fun getTransactions(): Call<StatementEntry>

    @Headers("token: $API_KEY")
    @GET("myStatement/detail/{id}")
    fun getDetailTransaction(@Path("id") id: String): Call<TransactionsEntry>


}
