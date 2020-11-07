package org.qgeff.cli

import org.qgeff.entity.Board
import org.qgeff.enums.Color

object PrettyPrinter {

    fun formatBoard(board: Board) {
        for (i in 0..4) {
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

    fun printBlueTurn(){
        println()
        println("----- BLUE TURN ----")
    }

    fun printRedTurn(){
        println()
        println("----- RED TURN ----")
    }
}