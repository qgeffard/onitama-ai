package org.qgeff

import org.qgeff.enums.Card
import org.qgeff.enums.Color

fun main() {

    val deck = pickFiveCards()

    println(deck)

    val player = Player(Color.BLUE, isAI = false)
    val ai = Player(Color.RED, isAI = true)

    distributeCards(deck, player, ai)
    println(player)
    println(ai)

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
