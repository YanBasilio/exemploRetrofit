package com.exemploretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.MultipartBody

class MainActivity : AppCompatActivity() {
    var disposable: Disposable? = null
    val RETROFIT_SERVE = RetrofitInitializer().service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val reqBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("token", "token123")
            .addFormDataPart("email", "Luan Fernando")
            .addFormDataPart("senha", "senha123")
            .build()

        disposable =
            RETROFIT_SERVE.autenticar_usuario(reqBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        Log.d("LoginActivity", "Login " + result.retorno?.usuario?.Usuario?.nome)
                    },
                    { error ->
                        Log.d("LoginActivity", "Erro " + error.message)

                    }
                )
    }
}
