package com.alejodfr.exercism

/*
 * Instructions
 *
 * Calculate the points scored in a single toss of a Darts game.
 *
 * Darts is a game where players throw darts at a target.
 * The target rewards 4 different amounts of points,
 * depending on where the dart lands:
 *
 *   - Outside the target:        0 points
 *   - Outer circle (radius 10):  1 point
 *   - Middle circle (radius 5):  5 points
 *   - Inner circle (radius 1):  10 points
 *
 * All circles are concentric, centered at (0, 0).
 *
 * Given a point (x, y), calculate the correct score earned
 * by a dart landing at that point.
 */

object Darts {

    fun score(x: Number, y: Number ): Int {
        var firstCordinate = x
        var secondCordinate = y
        var distance = Math.sqrt(Math.pow(firstCordinate.toDouble(), 2.0) + Math.pow(secondCordinate.toDouble(), 2.0))
        if (distance<=1){
            return 10
        } else if (distance<=5){
            return 5
        } else if (distance<=10){
            return 1
        } else {
            return 0
        }

    }
}

fun main(){
    println("Enter the x coordinate")
    val x = readLine()
    println("Enter the y coordinate")
    val y = readLine()
    println("The score is ${Darts.score(x.toString().toDouble(), y.toString().toDouble())}")
}
