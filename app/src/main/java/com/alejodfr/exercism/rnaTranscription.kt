package com.alejodfr.exercism

/**
 * Introduction
 *
 * You work for a bioengineering company that specializes in developing therapeutic solutions.
 * Your team has just been given a new project to develop a targeted therapy for a rare type of cancer.
 *
 * Note: It's all very complicated, but the basic idea is that sometimes people's bodies produce too much
 * of a given protein. That can cause all sorts of havoc.
 * But if you can create a very specific molecule (called a micro-RNA), it can prevent the protein from
 * being produced.
 * This technique is called RNA Interference.
 *
 * Instructions
 *
 * Your task is to determine the RNA complement of a given DNA sequence.
 * Both DNA and RNA strands are a sequence of nucleotides.
 * The four nucleotides found in DNA are adenine (A), cytosine (C), guanine (G), and thymine (T).
 * The four nucleotides found in RNA are adenine (A), cytosine (C), guanine (G), and uracil (U).
 * Given a DNA strand, its transcribed RNA strand is formed by replacing each nucleotide with its complement:
 *
 *     G -> C
 *     C -> G
 *     T -> A
 *     A -> U
 *
 * Note: If you want to look at how the inputs and outputs are structured, take a look at the examples
 * in the test suite.
 */

fun transcribeToRna(dna: String): String{
    return dna.toList().map { when(it){
        'G' -> 'C'
        'C' -> 'G'
        'T' -> 'A'
        'A' -> 'U'
        else -> throw IllegalArgumentException("Invalid nucleotide: $it")
    } }.joinToString("")
}

fun main() {
    println("Enter a DNA sequence:")
    val dna = readln()

    try {
        val result = transcribeToRna(dna)
        println("RNA complement: $result")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

/**
 * # RNA Transcription — Guía de resolución
 *
 * ## Paso 1 — Entender el problema
 *
 * Dado un String de DNA, reemplazar cada nucleótido
 * por su complemento de RNA según esta tabla:
 *
 *   G -> C
 *   C -> G
 *   T -> A
 *   A -> U
 *
 * Ejemplo:
 *   "GCTA" -> "CGAU"
 *   "ACGT" -> "UGCA"
 *
 * ## Paso 2 — Convertir el String a lista con `toList()`
 *
 * Un String no se puede transformar carácter por carácter directamente,
 * pero si lo convertimos a una lista de caracteres, podemos usar `map`.
 *
 *   "GCTA".toList()  // ['G', 'C', 'T', 'A']
 *
 * Cada elemento de la lista es un Char — un solo carácter.
 *
 * ## Paso 3 — Transformar cada carácter con `map` y `when`
 *
 * `map { }` recorre cada elemento de la lista y lo transforma.
 * `it` representa cada carácter en turno.
 * `when` mapea cada carácter a su complemento — es más limpio
 * que un if/else porque permite agrupar casos fácilmente.
 *
 *   .map { when(it) {
 *       'G' -> 'C'
 *       'C' -> 'G'
 *       'T' -> 'A'
 *       'A' -> 'U'
 *       else -> throw IllegalArgumentException("Invalid nucleotide: $it")
 *   }}
 *
 * IMPORTANTE: el `else` es obligatorio en `when` cuando no se cubren
 * todos los casos posibles. Aquí lanzamos una excepción si el carácter
 * no es un nucleótido válido.
 *
 * IMPORTANTE: no uses un String hardcodeado como "GCTA" dentro de la función.
 * Debes usar el parámetro `dna` que recibe la función, de lo contrario
 * siempre transformarías el mismo String sin importar el input.
 *
 * ## Paso 4 — Unir la lista en un String con `joinToString()`
 *
 * `map` retorna una lista de caracteres transformados:
 *   ['C', 'G', 'A', 'U']
 *
 * `joinToString("")` une todos los elementos en un solo String.
 * El "" entre paréntesis indica que no hay separador entre elementos.
 *
 *   listOf('C', 'G', 'A', 'U').joinToString("")  // "CGAU"
 *   listOf('C', 'G', 'A', 'U').joinToString("-") // "C-G-A-U"
 *
 * ## Paso 5 — Retornar el resultado
 *
 * `dna` es un parámetro de la función — no se puede reasignar.
 * En vez de intentar modificarlo, usamos `return` directamente
 * sobre el resultado de la cadena de transformaciones.
 *
 * ## Resultado final
 *
 *   fun transcribeToRna(dna: String): String {
 *       return dna.toList().map { when(it) {
 *           'G' -> 'C'
 *           'C' -> 'G'
 *           'T' -> 'A'
 *           'A' -> 'U'
 *           else -> throw IllegalArgumentException("Invalid nucleotide: $it")
 *       }}.joinToString("")
 *   }
 *
 * ## Flujo visual
 *
 *   "GCTA"
 *     ↓ toList()
 *   ['G', 'C', 'T', 'A']
 *     ↓ map { when(it) }
 *   ['C', 'G', 'A', 'U']
 *     ↓ joinToString("")
 *   "CGAU"
 *
 * ## Funciones clave utilizadas
 *
 *   toList()          — convierte un String en lista de caracteres (List<Char>)
 *   map { }           — transforma cada elemento de una lista, retorna lista nueva
 *   when              — evalúa un valor contra múltiples casos, como un switch
 *   it                — nombre implícito del parámetro en lambdas de un solo argumento
 *   else              — caso por defecto en when, obligatorio si no se cubren todos los casos
 *   joinToString("")  — une los elementos de una lista en un String sin separador
 *   return            — retorna el resultado de la función
 *   throw             — lanza una excepción y detiene la ejecución
 */