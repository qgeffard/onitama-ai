package org.qgeff.entity

import org.qgeff.entity.Pawn
import org.qgeff.enums.Card
import org.qgeff.enums.Color

class Player(val color: Color, val isAI: Boolean) {

    val hand = mutableListOf<Card>()
    val hold = mutableListOf<Card>()

    val pawns = mutableListOf<Pawn>()

    lateinit var selectedPawn: Pawn

    fun selectPawn(pawn: Pawn){
        selectedPawn = pawn
    }

    override fun toString(): String {
        return "Player(color=$color, isAI=$isAI, hand=$hand, hold=$hold, pawns=$pawns)"
    }


}