package org.qgeff.entity

import org.qgeff.enums.Card
import org.qgeff.enums.Color
import org.qgeff.enums.Direction
import kotlin.math.absoluteValue

object Board {
    val state = mutableListOf(
            Triple(0, 4, Pawn(0, false, Color.RED)), Triple(1, 4, Pawn(1, false, Color.RED)), Triple(2, 4, Pawn(2, true, Color.RED)), Triple(3, 4, Pawn(3, false, Color.RED)), Triple(4, 4, Pawn(4, false, Color.RED))
            , Triple(0, 3, null), Triple(1, 3, null), Triple(2, 3, null), Triple(3, 3, null), Triple(4, 3, null)
            , Triple(0, 2, null), Triple(1, 2, null), Triple(2, 2, null), Triple(3, 2, null), Triple(4, 2, null)
            , Triple(0, 1, null), Triple(1, 1, null), Triple(2, 1, null), Triple(3, 1, null), Triple(4, 1, null)
            , Triple(0, 0, Pawn(5, false, Color.BLUE)), Triple(1, 0, Pawn(6, false, Color.BLUE)), Triple(2, 0, Pawn(7, true, Color.BLUE)), Triple(3, 0, Pawn(8, false, Color.BLUE)), Triple(4, 0, Pawn(9, false, Color.BLUE))
    )

    fun applyCard(pawn: Pawn, direction: Triple<Direction, Int, Int>, currentPlayer: Player): List<Triple<Int, Int, Pawn?>> {
        val currentPawnCase = getCaseFromPawn(pawn)!!

        // revert board orientation by inverting pawn moves depending on the currentPlayer
        val newPawnCase =
                if(currentPlayer.color == Color.BLUE)
                    Triple(currentPawnCase.first+direction.second, currentPawnCase.second+direction.third,pawn)
                else
                    Triple(currentPawnCase.first+direction.second.opposite(), currentPawnCase.second+direction.third.opposite(),pawn)

        val oldPawnCase = getCaseFromXY(Pair(newPawnCase.first, newPawnCase.second))
        val newOldPawnCase = Triple(currentPawnCase.first, currentPawnCase.second, null)
        state.add(state.indexOf(oldPawnCase), newPawnCase)
        state.removeAt(state.indexOf(newPawnCase) + 1)

        state.add(state.indexOf(currentPawnCase),newOldPawnCase)
        state.removeAt(state.indexOf(newOldPawnCase)+1)
        return state
    }

    fun getCaseFromXY(coord:Pair<Int,Int>):Triple<Int,Int,Pawn?>{
        return state.find { case -> case.first == coord.first && case.second == coord.second }!!
    }

    fun getCaseFromPawn(pawn:Pawn): Triple<Int, Int, Pawn?>? {
        return state.find { case -> case.third == pawn }
    }

    fun getCol(colIndex: Int): List<Triple<Int, Int, Pawn?>> {
        return state.filter { case -> case.first == colIndex }
    }

    fun getRow(rowIndex: Int): List<Triple<Int, Int, Pawn?>> {
        return state.filter { case -> case.second == rowIndex }
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

    fun Int.opposite():Int{
        return when {
            this > 0 -> -(this.absoluteValue)
            this < 0 -> this.absoluteValue
            else -> 0
        }
    }
}