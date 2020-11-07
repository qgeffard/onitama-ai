package org.qgeff

import org.qgeff.enums.Card

object Board {
    var state = listOf(
        Triple(0,0,1), Triple(0,1,1), Triple(0,2,2), Triple(0,3,1), Triple(0,4,1)
        , Triple(1,0,0), Triple(1,1,0), Triple(1,2,0), Triple(1,3,0), Triple(1,4,0)
        , Triple(2,0,0), Triple(2,1,0), Triple(2,2,0), Triple(2,3,0), Triple(2,4,0)
        , Triple(3,0,0), Triple(3,1,0), Triple(3,2,0), Triple(3,3,0), Triple(3,4,0)
        , Triple(4,0,3), Triple(4,1,3), Triple(4,2,4), Triple(4,3,3), Triple(4,4,3)
    )

    fun applyCard(card : Card, player: Player, triple: Triple<Int,Int,Int>): List<Triple<Int, Int, Int>> {



        return state
    }

    fun getCol(colIndex : Int): List<Triple<Int, Int, Int>> {
        return state.filter { case -> case.second == colIndex }
    }

    fun getRow(rowIndex : Int): List<Triple<Int, Int, Int>> {
        return state.filter { case -> case.first == rowIndex }
    }

    fun getRedKngCell(): Triple<Int, Int, Int> {
        return state.first { case -> case.third == 4 }
    }

    fun getBlueKingCell(): Triple<Int, Int, Int> {
        return state.first { case -> case.third == 2 }
    }

    override fun toString(): String {
        return state.toString()
    }
}