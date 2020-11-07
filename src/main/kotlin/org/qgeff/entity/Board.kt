package org.qgeff.entity

import org.qgeff.enums.Card
import org.qgeff.enums.Color

object Board {
    var state: List<Triple<Int, Int, Pawn?>> = listOf(
            Triple(0, 0, Pawn(0, false, Color.RED)), Triple(0, 1, Pawn(1, false, Color.RED)), Triple(0, 2, Pawn(2, true, Color.RED)), Triple(0, 3, Pawn(3, false, Color.RED)), Triple(0, 4, Pawn(4, false, Color.RED))
            , Triple(1, 0, null), Triple(1, 1, null), Triple(1, 2, null), Triple(1, 3, null), Triple(1, 4, null)
            , Triple(2, 0, null), Triple(2, 1, null), Triple(2, 2, null), Triple(2, 3, null), Triple(2, 4, null)
            , Triple(3, 0, null), Triple(3, 1, null), Triple(3, 2, null), Triple(3, 3, null), Triple(3, 4, null)
            , Triple(4, 0, Pawn(5, false, Color.BLUE)), Triple(4, 1, Pawn(6, false, Color.BLUE)), Triple(4, 2, Pawn(7, true, Color.BLUE)), Triple(4, 3, Pawn(8, false, Color.BLUE)), Triple(4, 4, Pawn(9, false, Color.BLUE))
    )

    fun applyCard(card: Card, player: Player, triple: Triple<Int, Int, Pawn>): List<Triple<Int, Int, Pawn?>> {

        return state
    }

    fun getCol(colIndex: Int): List<Triple<Int, Int, Pawn?>> {
        return state.filter { case -> case.second == colIndex }
    }

    fun getRow(rowIndex: Int): List<Triple<Int, Int, Pawn?>> {
        return state.filter { case -> case.first == rowIndex }
    }

    fun getBluePawns(): List<Pawn> {
        return state.filter { case -> case.third != null && case.third!!.color == Color.BLUE }.map { case -> case.third!! }
    }

    fun getRedPawns(): List<Pawn> {
        return state.filter { case -> case.third != null && case.third!!.color == Color.RED }.map { case -> case.third!! }
    }

    override fun toString(): String {
        return state.toString()
    }
}