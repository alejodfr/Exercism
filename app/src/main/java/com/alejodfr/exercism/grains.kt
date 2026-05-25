package com.alejodfr.exercism
import java.math.BigInteger

/**
 * # Grains
 *
 * ## Introduction
 * There once was a wise servant who saved the life of a prince.
 * The king promised to pay whatever the servant could dream up.
 * Knowing that the king loved chess, the servant told the king he
 * would like to have grains of wheat. One grain on the first square
 * of a chessboard, with the number of grains doubling on each
 * successive square.
 *
 * ## Instructions
 * Calculate the number of grains of wheat on a chessboard.
 *
 * A chessboard has **64 squares**. Square 1 has one grain, square 2
 * has two grains, square 3 has four grains, and so on, doubling each
 * time.
 *
 * Write code that calculates:
 *
 * - The number of grains on a **given square**
 * - The **total number** of grains on the chessboard
 */

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        if (number < 1 || number > 64) throw IllegalArgumentException("Only integers between 1 and 64 (inclusive) are allowed")
        val bigNumber = BigInteger.valueOf(2)
        return bigNumber.pow(number - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        var total = BigInteger.ZERO
        for (i in 1..64){
            total += getGrainCountForSquare(i)
        }
        return total
    }
}

fun main(){
    println("Enter a number between 1 and 64")
    val number = readln().toInt()
    println("The number of grains on square $number is ${Board.getGrainCountForSquare(number)}")
    println("The total number of grains on the chessboard is ${Board.getTotalGrainCount()}")
}
