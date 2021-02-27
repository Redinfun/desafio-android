package br.com.desafio_phi.data.repository

import br.com.desafio_phi.data.model.StatementEntry
import br.com.desafio_phi.data.network.ApiDataInterface
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiPhiData: ApiDataInterface
) {
    suspend fun getStatements(queries:Map<String,String>):Response<StatementEntry>{
        return apiPhiData.getTransactions()
    }
}