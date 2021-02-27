package br.com.desafio_phi.data.network

import br.com.desafio_phi.data.model.BalanceEntry
import br.com.desafio_phi.data.model.StatementEntry
import br.com.desafio_phi.data.model.TransactionsEntry
import br.com.desafio_phi.utils.Constants
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiDataInterface {
    @Headers("token: ${Constants.API_KEY}")
    @GET("myBalance")
    suspend fun getBalance(): Response<BalanceEntry>

    @Headers("token: ${Constants.API_KEY}")
    @GET("myStatement/2000/0")
    suspend fun getTransactions(): Response<StatementEntry>

    @Headers("token: ${Constants.API_KEY}")
    @GET("myStatement/detail/{id}")
    suspend fun getDetailTransaction(@Path("id") id: String): Response<TransactionsEntry>
}