package com.alejodfr.exercism

/**
 * Instructions
 *
 * Each of us inherits from our biological parents a set of chemical instructions
 * known as DNA that influence how our bodies are constructed. All known life
 * depends on DNA!
 *
 *   Note: You do not need to understand anything about nucleotides or DNA to
 *   complete this exercise.
 *
 * DNA is a long chain of other chemicals and the most important are the four
 * nucleotides, adenine, cytosine, guanine and thymine. A single DNA chain can
 * contain billions of these four nucleotides and the order in which they occur
 * is important! We call the order of these nucleotides in a bit of DNA a "DNA
 * sequence".
 *
 * We represent a DNA sequence as an ordered collection of these four nucleotides
 * and a common way to do that is with a string of characters such as "ATTACG"
 * for a DNA sequence of 6 nucleotides. 'A' for adenine, 'C' for cytosine, 'G'
 * for guanine, and 'T' for thymine.
 *
 * Given a string representing a DNA sequence, count how many of each nucleotide
 * is present. If the string contains characters that aren't A, C, G, or T then
 * it is invalid and you should signal an error.
 *
 * For example:
 *
 *   "GATTACA" -> 'A': 3, 'C': 1, 'G': 1, 'T': 2
 *   "INVALID" -> error
 */

class Dna(val input: String) {

    init {
        input.filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }
            .forEach { throw IllegalArgumentException("Invalid nucleotide: $it") }
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            return mapOf(
                'A' to input.count { it == 'A' },
                'C' to input.count { it == 'C' },
                'G' to input.count { it == 'G' },
                'T' to input.count { it == 'T' }
            )
        }
}

fun main() {
    println("Enter a DNA sequence:")
    val input = readln()

    try {
        val dna = Dna(input)
        println(dna.nucleotideCounts)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

/**
 * # DNA Nucleotide Count — Guía de resolución
 *
 * ## Paso 1 — Entender el problema
 *
 * Dado un String que representa una secuencia de DNA,
 * contar cuántas veces aparece cada nucleótido: A, C, G, T.
 * Si el String contiene caracteres inválidos, lanzar una excepción.
 *
 * Ejemplo:
 *   "GATTACA" -> {A=3, C=1, G=1, T=2}
 *   "INVALID" -> IllegalArgumentException
 *
 * ## Paso 2 — Definir la clase y el constructor
 *
 * La clase recibe el String de entrada como parámetro.
 * `nucleotideCounts` es una propiedad calculada con get()
 * que se ejecuta cada vez que la llamas.
 *
 *   class Dna(val input: String) {
 *       val nucleotideCounts: Map<Char, Int>
*           get() { ... }
 *   }
 *
 * ## Paso 3 — Validar el input con `init`
 *
 * IMPORTANTE: la validación debe ir en el bloque `init`, NO dentro de get().
 *
 * ¿Por qué? Porque init se ejecuta al momento de crear el objeto:
 *   Dna("AGXXACT")  <- la excepción se lanza aquí
 *
 * Si la validación estuviera en get(), solo se ejecutaría cuando
 * alguien llame dna.nucleotideCounts — y algunos tests crean el objeto
 * sin llamar esa propiedad, por lo que nunca detectarían el error.
 *
 * Usamos filter() para quedarnos con los caracteres inválidos,
 * y forEach() para lanzar la excepción por cada uno encontrado.
 *
 * Nota: el operador entre condiciones es && (Y) no || (O).
 * Con ||, un carácter 'A' cumpliría it != 'C' y siempre filtraría to-do.
 * Con &&, solo filtra si NO es ninguna de las cuatro letras válidas.
 *
 *   init {
 *       input.filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }
 *            .forEach { throw IllegalArgumentException("Invalid nucleotide: $it") }
 *   }
 *
 * ## Paso 4 — Contar los nucleótidos
 *
 * Usamos count() con un lambda para contar cuántas veces
 * aparece cada nucleótido en el String.
 *
 * En vez de declarar 4 variables separadas (count1, count2...),
 * usamos count() directamente al construir el mapa.
 *
 *   return mapOf(
 *       'A' to input.count { it == 'A' },
 *       'C' to input.count { it == 'C' },
 *       'G' to input.count { it == 'G' },
 *       'T' to input.count { it == 'T' }
 *   )
 *
 * ## Resultado final
 *
 *   class Dna(val input: String) {
 *
 *       init {
 *           input.filter { it != 'A' && it != 'C' && it != 'G' && it != 'T' }
 *                .forEach { throw IllegalArgumentException("Invalid nucleotide: $it") }
 *       }
 *
 *       val nucleotideCounts: Map<Char, Int>
 *           get() {
 *               return mapOf(
 *                   'A' to input.count { it == 'A' },
 *                   'C' to input.count { it == 'C' },
 *                   'G' to input.count { it == 'G' },
 *                   'T' to input.count { it == 'T' }
 *               )
 *           }
 *   }
 *
 * ## Funciones clave utilizadas
 *
 *   filter { }   — conserva solo los elementos que cumplan la condición
 *   forEach { }  — ejecuta un bloque por cada elemento
 *   count { }    — cuenta cuántos elementos cumplen la condición
 *   throw        — lanza una excepción y detiene la ejecución
 *   init         — se ejecuta al crear el objeto, ideal para validaciones
 *   get()        — propiedad calculada, se ejecuta cada vez que la llamas
 */