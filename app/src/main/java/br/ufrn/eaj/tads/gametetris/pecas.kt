package br.ufrn.eaj.tads.gametetris

abstract class pecas(var x: Int, var y: Int) {
    var pontoA = Ponto(x, y)
    var rotated = false
    lateinit var pontoB: Ponto
    lateinit var pontoC: Ponto
    lateinit var pontoD: Ponto

    abstract fun moverBaixo()
    abstract fun moverEsquerda()
    abstract fun moverDireita()
    abstract fun girar()
}