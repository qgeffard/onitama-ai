package org.qgeff.cli

import org.qgeff.entity.Board
import org.qgeff.entity.Pawn
import org.qgeff.entity.Player
import org.qgeff.enums.Card
import org.qgeff.enums.Color

object PrettyPrinter {

    fun printBoard(board: Board) {
        for (i in 4 downTo 0) {
            println(board.getRow(i).map {
                if (it.third != null)
                    if (it.third!!.color == Color.BLUE)
                        if (it.third!!.isKing)
                            "bK "
                        else "bP "
                    else
                        if (it.third!!.isKing)
                            "rK "
                        else "rP "
                else
                    "__ "
            })
        }
    }

    fun printTurn(player: Player){
        println()
        println("----- ${player.color} TURN ----")
    }

    fun printCards(hand: MutableList<Card>) {
        println("Choose a card to play :")
        for (i in hand.indices)
            println("$i => ${hand[i]}")
    }

    fun printPawns(pawns: MutableList<Pawn>) {
        println("Choose a pawn to move :")
        for (i in pawns.indices)
            println("$i => ${pawns[i]}")
    }

    fun printCardDirections(card: Card) {
        println("Choose a $card 's direction :")
        for (i in card.directions.indices)
            println("$i => ${card.directions[i]}")
    }
}