package br.ufrn.eaj.tads.gametetris

class obj7(x:Int, y:Int) : pecas(x,y) {

    init {
        pontoB = Ponto(x, y - 1);
        pontoC = Ponto(x, y + 1);
        pontoD = Ponto(x, y + 2);
    }

    override fun moverBaixo() {
        pontoA.moverBaixo()
        pontoB.moverBaixo()
        pontoC.moverBaixo()
        pontoD.moverBaixo()
    }

    override fun moverEsquerda() {
        pontoA.moverEsquerda()
        pontoB.moverEsquerda()
        pontoC.moverEsquerda()
        pontoD.moverEsquerda()
    }

    override fun moverDireita() {
        pontoA.moverDireita()
        pontoB.moverDireita()
        pontoC.moverDireita()
        pontoD.moverDireita()
    }

    override fun girar() {
        if(!rotated) {
            pontoB.x--
            pontoB.y++

            pontoC.x++
            pontoC.y--

            pontoD.y -= 2
            pontoD.x += 2

            rotated = true
        } else {
            pontoB.x++
            pontoB.y--

            pontoC.x--
            pontoC.y++

            pontoD.y += 2
            pontoD.x -= 2

            rotated = false
        }
    }
}