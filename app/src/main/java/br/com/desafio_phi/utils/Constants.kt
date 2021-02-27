package br.com.desafio_phi.utils

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import br.com.desafio_phi.ui.view.StatementActivity

class Constants {
    companion object{
        const val BASE_URL = "https://desafio-mobile-bff.herokuapp.com/"
        const val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
        val APPLICATION_NAME_KEY = StatementActivity::class.qualifiedName
    }
}