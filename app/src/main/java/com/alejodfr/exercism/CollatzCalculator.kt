package com.alejodfr.exercism

/*
 * Collatz Conjecture (3n + 1)
 *
 * One evening, you stumbled upon an old notebook filled with cryptic scribbles.
 * On one page, a single question stood out: Can every number find its way to 1?
 * It was tied to something called the Collatz Conjecture, a puzzle that has
 * baffled thinkers for decades.
 *
 * The rules are deceptively simple. Pick any positive integer:
 *   - If it's even, divide it by 2.
 *   - If it's odd, multiply it by 3 and add 1.
 *
 * Then, repeat these steps with the result, continuing indefinitely.
 *
 * Example with 12: 12 -> 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It took 9 steps to reach 1.
 *
 * Instructions:
 * Given a positive integer, return the number of steps it takes to reach 1
 * according to the rules of the Collatz Conjecture.
 */

object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        if (start <= 0) throw IllegalArgumentException("Only positive integers are allowed")
        var current = start
        var count = 0
        while (current != 1){
            if (current % 2 == 0){
                current = current / 2
            } else {
                current = (current * 3) + 1
            }
            count++
        }
        return count
    }
}

fun main(){
    println("Enter a number")
    val step = readLine()
    println("It took ${CollatzCalculator.computeStepCount(step.toString().toInt())} steps to reach 1")
}

