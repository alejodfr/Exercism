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
 *   - The number of grains on a **given square**
 *   - The **total number** of grains on the chessboard
 *
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

/**
* * ## Resolution Guide
 *
 * The number of grains on each square follows a powers-of-two pattern:
 *
 *   Square  | Grains | Expression
 *   --------|--------|-----------
 *   1       | 1      | 2^0
 *   2       | 2      | 2^1
 *   3       | 4      | 2^2
 *   4       | 8      | 2^3
 *   ...     | ...    | ...
 *   n       | 2^(n-1) | 2^(n-1)
 *
 * Key points:
 *
 *   - Grains on square N = 2^(N - 1)
 *   - Total grains on all 64 squares = 2^64 - 1
 *
 * Since the result exceeds the range of Int and Long, use BigInteger:
 *
 *   BigInteger.valueOf(2).pow(square - 1)
 *
 * For the total, sum all squares or use the formula:
 *   2^64 - 1 (which equals 18,446,744,073,709,551,615)
 *
 * Edge case: square must be between 1 and 64 inclusive,
 * otherwise throw IllegalArgumentException.
* */