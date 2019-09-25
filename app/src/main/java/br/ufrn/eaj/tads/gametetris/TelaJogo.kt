package br.ufrn.eaj.tads.gametetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.LayoutInflater
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class TelaJogo : AppCompatActivity() {

    val LINHA = 36
    val COLUNA = 22
    var running = true
    var speed: Long = 300

    var pt = PecaI(4, 12)

    //val board = Array(LINHA, { IntArray(COLUNA) })

    var board = Array(LINHA) {
        Array(COLUNA) { 0 }
    }

    var boardView = Array(LINHA) {
        arrayOfNulls<ImageView>(COLUNA)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridboard.rowCount = LINHA
        gridboard.columnCount = COLUNA

        val inflater = LayoutInflater.from(this)

        for (i in 0 until LINHA) {
            for (j in 0 until COLUNA) {
                boardView[i][j] =
                    inflater.inflate(R.layout.inflate_image_view, gridboard, false) as ImageView
                gridboard.addView(boardView[i][j])
            }
        }

        gameRun()

        btnDireta.setOnClickListener {
            if (colisaoDireita())
                pt.moverDireita()
        }

        btnEsquerda.setOnClickListener {
            if (colisaoEsquerda())
                pt.moverEsquerda()
        }

        btnGirar.setOnClickListener {
            if (colisaoDireita() && colisaoEsquerda() && colisaoFundo())
            pt.girar()
        }

        btnDescer.setOnClickListener {
            if (colisaoFundo())
                pt.moverBaixo()
        }

    }

    fun colisaoFundo(): Boolean {
        return ((pt.pontoA.x + 1 < LINHA && board[pt.pontoA.x + 1][pt.pontoA.y] < 1) &&
                (pt.pontoB.x + 1 < LINHA && board[pt.pontoB.x + 1][pt.pontoB.y] < 1) &&
                (pt.pontoC.x + 1 < LINHA && board[pt.pontoC.x + 1][pt.pontoC.y] < 1) &&
                (pt.pontoD.x + 1 < LINHA && board[pt.pontoD.x + 1][pt.pontoD.y] < 1))
    }

    fun colisaoDireita(): Boolean {
        return ((pt.pontoA.y + 1 < COLUNA && board[pt.pontoA.x][pt.pontoA.y + 1] < 1) &&
                (pt.pontoB.y + 1 < COLUNA && board[pt.pontoB.x][pt.pontoB.y + 1] < 1) &&
                (pt.pontoC.y + 1 < COLUNA && board[pt.pontoC.x][pt.pontoC.y + 1] < 1) &&
                (pt.pontoD.y + 1 < COLUNA && board[pt.pontoD.x][pt.pontoD.y + 1] < 1))
    }

    fun colisaoEsquerda(): Boolean {
        return ((pt.pontoA.y - 1 >= 0 && board[pt.pontoA.x][pt.pontoA.y - 1] < 1) &&
                (pt.pontoB.y - 1 >= 0 && board[pt.pontoB.x][pt.pontoB.y - 1] < 1) &&
                (pt.pontoC.y - 1 >= 0 && board[pt.pontoC.x][pt.pontoC.y - 1] < 1) &&
                (pt.pontoD.y - 1 >= 0 && board[pt.pontoD.x][pt.pontoD.y - 1] < 1))
    }

    fun gameRun() {
        Thread {
            while (running) {
                Thread.sleep(speed)
                runOnUiThread {
                    //limpa tela
                    for (i in 0 until LINHA) {
                        for (j in 0 until COLUNA) {
                            if (board[i][j] == 0)
                                boardView[i][j]!!.setImageResource(R.drawable.black)
                            else
                                boardView[i][j]!!.setImageResource(R.drawable.white)
                        }
                    }
                    //move peça atual
                    if (colisaoFundo()) {
                        pt.moverBaixo()
                    } else {
                        board[pt.pontoA.x][pt.pontoA.y] = 1
                        board[pt.pontoB.x][pt.pontoB.y] = 1
                        board[pt.pontoC.x][pt.pontoC.y] = 1
                        board[pt.pontoD.x][pt.pontoD.y] = 1
                        pt = PecaI(0, 12)
                    }

                    boardView[pt.pontoA.x][pt.pontoA.y]!!.setImageResource(R.drawable.white)
                    boardView[pt.pontoB.x][pt.pontoB.y]!!.setImageResource(R.drawable.white)
                    boardView[pt.pontoC.x][pt.pontoC.y]!!.setImageResource(R.drawable.white)
                    boardView[pt.pontoD.x][pt.pontoD.y]!!.setImageResource(R.drawable.white)

                }
            }
        }.start()
    }
}
