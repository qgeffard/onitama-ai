package org.qgeff

import org.qgeff.cli.PrettyPrinter
import org.qgeff.entity.Board
import org.qgeff.entity.Player
import org.qgeff.enums.Card
import org.qgeff.enums.Color
import kotlin.system.exitProcess

fun main() {

    val deck = pickFiveCards()
    val player = Player(Color.BLUE, isAI = false)
    val ai = Player(Color.RED, isAI = true)

    distributeCards(deck, player, ai)
    assignPawns(player,ai, Board)

    println(player)
    println(ai)

    start(player,ai,Board)
}

fun start(player: Player, ai: Player, board: Board) {
    turn(player,ai,board)

    PrettyPrinter.printBoard(board)
}

fun turn(currentPlayer: Player, adversary: Player, board: Board) {
    PrettyPrinter.printTurn(currentPlayer)
    PrettyPrinter.printBoard(board)

    //card choice
    PrettyPrinter.printCards(currentPlayer.hand)
    val selectedCard = currentPlayer.hand[readLine()!!.toInt()]

    //pawn choice
    PrettyPrinter.printPawns(currentPlayer.pawns)
    val selectedPawn = currentPlayer.pawns[readLine()!!.toInt()]

    //direction choice
    PrettyPrinter.printCardDirections(selectedCard)
    val selectedDirection = selectedCard.directions[readLine()!!.toInt()]

    //Apply player choices to the board
    board.applyCard(selectedPawn, selectedDirection, currentPlayer)

    //Check victory condition
    if (checkVictory(board)) {
        println("$currentPlayer wins !")
        exitProcess(0)
    }

    //Remove used card from current player hand
    currentPlayer.hand.remove(selectedCard)
    adversary.hold.add(selectedCard)
    currentPlayer.hand.add(currentPlayer.hold.first())
    currentPlayer.hold.clear()

    turn(adversary,currentPlayer,board)
}

fun checkVictory(board: Board): Boolean {
    return checkBluePathOfTheStone(board)
            || checkBluePathOfTheStream(board)
            || checkRedPathOfTheStone(board)
            || checkRedPathOfTheStream(board)

}

fun checkBluePathOfTheStone(board: Board):Boolean {
    return !board.state.any { case -> case.third != null
            && case.third!!.color == Color.RED
            && case.third!!.isKing }
}

fun checkRedPathOfTheStone(board: Board):Boolean {
    return !board.state.any { case -> case.third != null
            && case.third!!.color == Color.BLUE
            && case.third!!.isKing }
}

fun checkBluePathOfTheStream(board: Board):Boolean {
    return board.state.any { case -> case.first == 2
                && case.second == 4
                && case.third != null
                && case.third!!.color == Color.BLUE
                && case.third!!.isKing }
}

fun checkRedPathOfTheStream(board: Board):Boolean {
    return board.state.any { case -> case.first == 2
            && case.second == 0
            && case.third != null
            && case.third!!.color == Color.RED
            && case.third!!.isKing }
}

fun checkPathOfTheStream(board: Board):Boolean {
    TODO("Not yet implemented")
}

fun assignPawns(player: Player, ai: Player, board: Board) {
    player.pawns.addAll(board.getBluePawns())
    ai.pawns.addAll(board.getRedPawns())
}

fun distributeCards(deck: Set<Card>, player: Player, ai: Player) {
    val chunkedDeck = deck.chunked(2)
    player.hand.addAll(chunkedDeck.first())
    ai.hand.addAll(chunkedDeck.drop(1).first())
    player.hold.addAll(chunkedDeck.last())
}

fun pickFiveCards(): Set<Card> {
    var set = emptySet<Card>()
    do {
        set = set.plus(Card.getRandomCard())
    } while (set.size < 5)
    return set
}
