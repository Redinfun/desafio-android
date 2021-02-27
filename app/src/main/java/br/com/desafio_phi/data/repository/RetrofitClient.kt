package br.com.desafio_phi.data.repository

import br.com.desafio_phi.data.network.ApiDataInterface
import br.com.desafio_phi.data.network.ApiPhiData
import br.com.desafio_phi.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {



    private val retrofitClient: Retrofit.Builder by lazy {


        val okHttpClient = OkHttpClient.Builder()


        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val getService: ApiPhiData by lazy {
        retrofitClient
            .build()
            .create(ApiPhiData::class.java)
    }
}