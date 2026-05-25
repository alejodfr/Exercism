package com.alejodfr.exercism

/**
 * Introduction
 *
 * A leap year (in the Gregorian calendar) occurs:
 *
 *   - In every year that is evenly divisible by 4.
 *   - Unless the year is evenly divisible by 100, in which case it's only a
 *     leap year if the year is also evenly divisible by 400.
 *
 * Some examples:
 *
 *   - 1997 was not a leap year as it's not divisible by 4.
 *   - 1900 was not a leap year as it's not divisible by 400.
 *   - 2000 was a leap year!
 *
 * Note
 *
 * For a delightful, four-minute explanation of the whole phenomenon of leap
 * years, check out this YouTube video.
 *
 * Instructions
 *
 * Your task is to determine whether a given year is a leap year.
 */

data class Year(val year: Int) {
    val isLeap: Boolean
        get() = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0

}

fun main(){
    println("Enter a year")
    val year = readln().toInt()
    println("Is $year a leap year? ${Year(year).isLeap}")
}

/**
 * get() es una propiedad calculada — en vez de almacenar un valor fijo,
 * lo calcula cada vez que la llamas.
 *
 * Ejemplo:
 *
 * data class Circle(val radius: Double) {
 *     val area: Double
 *         get() = 3.14 * radius * radius
 * }
 *
 * val c = Circle(5.0)
 * println(c.area)  // 78.5
 *
 * No es una función, no tiene paréntesis al llamarla —
 * se usa como variable normal pero su valor se calcula en el momento.
 */