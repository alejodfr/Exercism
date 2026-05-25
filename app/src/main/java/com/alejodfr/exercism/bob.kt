package com.alejodfr.exercism  // Declares the package namespace

object Bob {  // Singleton object representing Bob
    fun hey(input: String): String {  // Returns Bob's reply based on input
        val isYelling = input.uppercase() == input && input.any { it.isLetter() }  // True if input is all uppercase with letters
        val isQuestion = input.trim().endsWith("?")  // True if input ends with ?

        when {  // Evaluate input characteristics
            isYelling && isQuestion -> return "Calm down, I know what I'm doing!"  // Yelled question
            isQuestion -> return "Sure."  // Normal question
            isYelling -> return "Whoa, chill out!"  // Yelling statement
            input.isBlank() -> return "Fine. Be that way!"  // Blank input
            else -> return "Whatever."  // Anything else
        }
    }
}

fun main(){  // Entry point for interactive testing
    println("Tell bob something")  // Prompt user
    val input = readLine()  // Read user input from stdin
    println(Bob.hey(input.toString()))  // Print Bob's response
}

/*
 * any() es una función de extensión en Kotlin que devuelve true si al menos un elemento
 * de la colección cumple con la condición dada. Recibe un predicado (lambda) como argumento.
 *
 * Lambda: es una función anónima que puede ser pasada como expresión. En Kotlin se escribe
 * entre llaves { parametro -> expresion }. Cuando solo hay un parámetro, se puede omitir
 * y usar "it" para referirse a él. Ej: { it.isLetter() } es equivalente a { c -> c.isLetter() }
 *
 * En Bob, input.any { it.isLetter() } verifica si algún carácter en input es una letra.
 */
