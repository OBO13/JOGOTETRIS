package br.ufrn.eaj.tads.gametetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_tela_game_over.*
import kotlinx.android.synthetic.main.activity_tela_game_over.*

class TelaGameOver : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_game_over)

       btnNovoJogo.setOnClickListener {
            var i = Intent(this, TelaJogo::class.java)
            startActivity(i)
        }

        btnSair.setOnClickListener {
            finish()
        }
    }
}
