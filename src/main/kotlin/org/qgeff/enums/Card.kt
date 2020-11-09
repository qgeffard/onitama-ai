package org.qgeff.enums

import java.util.*

enum class Card {

    /**
     * 00100
     * 00000
     * 00x00
     * 00100
     * 00000
     */
    TIGER {
        override val directions = listOf(
                Triple(Direction.N,0,2)
                , Triple(Direction.S,0,-1))
    },

    /**
     * 00000
     * 10001
     * 00x00
     * 01010
     * 00000
     */
    DRAGON{
        override val directions = listOf(
                Triple(Direction.NW, -2,1)
                , Triple(Direction.NE, 2,1)
                , Triple(Direction.SE, 1,-1)
                , Triple(Direction.SW, -1, -1))
    },

    /**
     * 00000
     * 01000
     * 10x00
     * 00010
     * 00000
     */
    FROG{
        override val directions = listOf(
                Triple(Direction.W, -2, 0)
                , Triple(Direction.NW, -1,1)
                , Triple(Direction.SE, 1,-1))
    },

    /**
     * 00000
     * 00010
     * 00x01
     * 01000
     * 00000
     */
    RABBIT{
        override val directions = listOf(
                Triple(Direction.SW,-1,-1)
                , Triple(Direction.NE, 1,1)
                , Triple(Direction.W,2,0))
    },

    /**
     * 00000
     * 00100
     * 10x01
     * 00000
     * 00000
     */
    CRAB{
        override val directions = listOf(
                Triple(Direction.W,-2,0)
                , Triple(Direction.N,0,1)
                , Triple(Direction.E,2,0))
    },

    /**
     * 00000
     * 01010
     * 01x10
     * 00000
     * 00000
     */
    ELEPHANT{
        override val directions = listOf(
                Triple(Direction.W, -1,0)
                , Triple(Direction.NW, -1,1)
                , Triple(Direction.NE, 1,1)
                , Triple(Direction.E, 1,0))
    },

    /**
     * 00000
     * 01000
     * 01x10
     * 00010
     * 00000
     */
    GOOSE{
        override val directions = listOf(
                Triple(Direction.W,-1,0)
                , Triple(Direction.NW, -1,1)
                , Triple(Direction.E, 1,0)
                , Triple(Direction.SE,1,-1))
    },

    /**
     * 00000
     * 00010
     * 01x10
     * 01000
     * 00000
     */
    ROOSTER{
        override val directions = listOf(
                Triple(Direction.SW, -1,-1)
                , Triple(Direction.W,-1,0)
                , Triple(Direction.NE,1,1)
                , Triple(Direction.E,1,0))
    },

    /**
     * 00000
     * 01010
     * 00x00
     * 01010
     * 00000
     */
    MONKEY{
        override val directions = listOf(
                Triple(Direction.SW,-1,-1)
                , Triple(Direction.NW,-1,1)
                , Triple(Direction.NE,1,1)
                , Triple(Direction.SE,1,-1))
    },

    /**
     * 00000
     * 01010
     * 00x00
     * 00100
     * 00000
     */
    MANTIS{
        override val directions = listOf(
                Triple(Direction.NW,-1,1)
                , Triple(Direction.NE, 1,1)
                , Triple(Direction.S, 0,-1))
    },

    /**
     * 00000
     * 00100
     * 01x00
     * 00100
     * 00000
     */
    HORSE{
        override val directions = listOf(
                Triple(Direction.W, -1,0)
                , Triple(Direction.N, 0,1)
                , Triple(Direction.S, 0,-1))
    },

    /**
     * 00000
     * 00100
     * 00x10
     * 00100
     * 00000
     */
    OX{
        override val directions = listOf(
                Triple(Direction.N,0,1)
                , Triple(Direction.E,1,0)
                , Triple(Direction.S,0,-1))
    },

    /**
     * 00000
     * 00100
     * 00x00
     * 01010
     * 00000
     */
    CRANE{
        override val directions = listOf(
                Triple(Direction.SW,-1,-1)
                , Triple(Direction.N,0,1)
                , Triple(Direction.SE,1,-1))
    },

    /**
     * 00000
     * 00100
     * 01x10
     * 00000
     * 00000
     */
    BOAR{
        override val directions = listOf(
                Triple(Direction.W,-1,0)
                , Triple(Direction.N,0,1)
                , Triple(Direction.E,1,0))
    },

    /**
     * 00000
     * 01000
     * 00x10
     * 01000
     * 00000
     */
    EEL{
        override val directions = listOf(
                Triple(Direction.SW,-1,-1)
                , Triple(Direction.NW,-1,1)
                , Triple(Direction.E,1,0))
    },

    /**
     * 00000
     * 00010
     * 01x00
     * 00010
     * 00000
     */
    COBRA{
        override val directions = listOf(
                Triple(Direction.W,-1,0)
                , Triple(Direction.NE, 1,1)
                , Triple(Direction.SE, 1,-1))
    };

    abstract val directions : List<Triple<Direction,Int,Int>>

    companion object{
        /**
         * Pick a random Card .
         * @return a random Card.
         */
        open fun getRandomCard(): Card {
            return values()[Random().nextInt(values().size)]
        }
    }

}