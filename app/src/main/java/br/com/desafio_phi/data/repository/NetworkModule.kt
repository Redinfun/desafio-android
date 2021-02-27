package br.com.desafio_phi.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.desafio_phi.data.model.BalanceEntry
import br.com.desafio_phi.data.model.StatementEntry
import br.com.desafio_phi.data.model.TransactionsEntry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NetworkModule {

    val balanceLiveData = MutableLiveData<BalanceEntry>()
    val statementLiveData = MutableLiveData<TransactionsEntry>()
    var transactionsList = mutableListOf<TransactionsEntry>()
    val transactionsLiveData = MutableLiveData<StatementEntry>()


     fun getBalance(): MutableLiveData<BalanceEntry> {

        val call = RetrofitClient.getService.getBalance()

        call.enqueue(object : Callback<BalanceEntry> {

            override fun onFailure(call: Call<BalanceEntry>, t: Throwable) {
                Log.e("Anthoni", "getBalance Fail")
            }

            override fun onResponse(call: Call<BalanceEntry>, response: Response<BalanceEntry>) {

                val data = response.body()

                val balance = data?.amountBalance

                balanceLiveData.value = BalanceEntry(balance ?: 0.0)

            }


        })

        return balanceLiveData


    }

     fun getTransactions(): MutableLiveData<StatementEntry> {

        val call = RetrofitClient.getService.getTransactions()

        call.enqueue(object : Callback<StatementEntry> {
            override fun onResponse(
                call: Call<StatementEntry>,
                response: Response<StatementEntry>
            ) {


                val data = response.body()

                transactionsLiveData.value = data
                transactionsList = data?.statements as MutableList<TransactionsEntry>


            }

            override fun onFailure(call: Call<StatementEntry>, t: Throwable) {
                Log.e("Anthoni", "getTransactions Fail")
            }

        })

        return transactionsLiveData


    }


     fun getDetailTransaction(id: String): MutableLiveData<TransactionsEntry> {

        val call = RetrofitClient.getService.getDetailTransaction(id)

        call.enqueue(object : Callback<TransactionsEntry> {
            override fun onResponse(
                call: Call<TransactionsEntry>,
                response: Response<TransactionsEntry>
            ) {
                val data = response.body()
                statementLiveData.value = data
            }

            override fun onFailure(call: Call<TransactionsEntry>, t: Throwable) {
                Log.e("Anthoni", "getDetails Fail")
            }

        })


        return statementLiveData


    }
}