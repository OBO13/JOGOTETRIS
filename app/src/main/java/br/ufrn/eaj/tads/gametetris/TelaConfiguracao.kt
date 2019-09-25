package br.ufrn.eaj.tads.gametetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TelaConfiguracao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_configuracao)
    }


    fun Cancelar (view: View) {

        var i = Intent(this, TelaInicial::class.java)
        var b = Bundle()
        i.putExtras(b)
        startActivity(i)
    }
}
