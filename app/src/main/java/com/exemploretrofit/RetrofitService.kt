package com.exemploretrofit

import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST("autenticacao/autenticar_usuario")
    fun autenticar_usuario(@Body data: RequestBody): Observable<UsuarioResponse.Result>

}