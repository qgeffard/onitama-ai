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

    start()


}

fun start() {

    PrettyPrinter.formatBoard(Board)
    PrettyPrinter.printBlueTurn()





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
