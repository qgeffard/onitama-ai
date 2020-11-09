package org.qgeff

import org.qgeff.cli.PrettyPrinter
import org.qgeff.entity.Board
import org.qgeff.entity.Player
import org.qgeff.enums.Card
import org.qgeff.enums.Color

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


    PrettyPrinter.printBlueTurn()
    blueTurn(player,board)

    PrettyPrinter.printBoard(board)

}

fun blueTurn(player: Player, board: Board) {
    PrettyPrinter.printBoard(board)

    //card choice
    PrettyPrinter.printCards(player.hand)
    val selectedCard = player.hand[readLine()!!.toInt()]

    //pawn choice
    PrettyPrinter.printPawns(player.pawns)
    val selectedPawn = player.pawns[readLine()!!.toInt()]

    //direction choice
    PrettyPrinter.printCardDirections(selectedCard)
    val selectedDirection = selectedCard.directions[readLine()!!.toInt()]

    //Apply player choices to the board
    board.applyCard(selectedCard, selectedPawn, selectedDirection)


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
