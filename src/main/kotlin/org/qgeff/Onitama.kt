package org.qgeff

import org.qgeff.enums.Color
import kotlin.random.Random

fun main(){

    val player = if (Random.nextBoolean()) Player(Color.BLUE) else Player(Color.RED)

    println(player)

}