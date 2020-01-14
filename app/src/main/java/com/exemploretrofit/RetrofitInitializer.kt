package com.exemploretrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val BASE_URL = "http://translogtransportes.com.br/gerenciar_homolog/api/rest/"

    var retrofit: Retrofit? = null
    val service: RetrofitService
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            }
            return retrofit!!.create(RetrofitService::class.java)
        }
}