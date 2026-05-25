package com.alejodfr.exercism

/*
 * # Eliud's Eggs
 *
 * ## Introduction
 * Your friend Eliud inherited a farm from her grandma Tigist.
 * Her granny was an inventor and had a tendency to build things
 * in an overly complicated manner. The chicken coop has a digital
 * display showing an encoded number representing the positions of
 * all eggs that could be picked up.
 *
 * Eliud is asking you to write a program that shows the actual
 * number of eggs in the coop.
 *
 * ## Encoding
 * The position information encoding is calculated as follows:
 *
 * 1. Scan the potential egg-laying spots and mark down a **1**
 *    for an existing egg or a **0** for an empty spot.
 * 2. Convert the number from **binary** to **decimal**.
 * 3. Show the result on the display.
 */

object EliudsEggs {

    fun eggCount(number: Int): Int{
        val num = number
        val binary = num.toString(2) // transformar a binario
        val count = binary.count { it == '1' } // cuenta cuantos '1' hay en el binario
        return count
    }
}

fun main(){
    println("Enter the number")
    val number = readln().toInt()
    println("Decimal number on the display: $number")
    println("Actual eggs in the coop: ${EliudsEggs.eggCount(number)}")
}
