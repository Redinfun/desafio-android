package br.com.desafio_phi.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.desafio_phi.data.model.BalanceEntry
import br.com.desafio_phi.data.model.StatementEntry
import br.com.desafio_phi.data.model.TransactionsEntry
import br.com.desafio_phi.data.repository.NetworkModule

class MyViewModel(private val repository: NetworkModule) : ViewModel() {


     fun getBalance(): LiveData<BalanceEntry> {


        return repository.getBalance()
    }

     fun getTransactions(): LiveData<StatementEntry> {


        return repository.getTransactions()
    }

     fun getDetailTransaction(id: String): LiveData<TransactionsEntry> {


        return repository.getDetailTransaction(id)

    }


    class MainViewModelFactory(private val repository: NetworkModule) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MyViewModel(repository) as T
        }

    }
}