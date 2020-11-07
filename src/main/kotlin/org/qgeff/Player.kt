package org.qgeff

import org.qgeff.enums.Card
import org.qgeff.enums.Color

class Player(val color: Color, val isAI: Boolean) {

    val hand = mutableListOf<Card>()
    val hold = mutableListOf<Card>()

    override fun toString(): String {
        return "Player(color=$color, isAI=$isAI, hand=$hand, hold=$hold)"
    }


}