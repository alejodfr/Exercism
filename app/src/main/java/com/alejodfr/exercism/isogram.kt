package com.alejodfr.exercism

/**
 * Instructions
 *
 * Determine if a word or phrase is an isogram.
 *
 * An isogram (also known as a "non-pattern word") is a word or phrase without a
 * repeating letter, however spaces and hyphens are allowed to appear multiple times.
 *
 * Examples of isograms:
 *
 *   - lumberjacks
 *   - background
 *   - downstream
 *   - six-year-old
 *
 * The word isograms, however, is not an isogram, because the s repeats.
 */

object Isogram {

    fun isIsogram(input: String): Boolean {
        val letters = input.filter { it != '-' && it != ' ' }.lowercase()
        return letters.length == letters.toList().distinct().size
    }
}



fun main(){
    println("Type a word or phrase")
    val input = readln()
    println("Is the word or phrase an isogram? ${Isogram.isIsogram(input)}")
}

/**
 * input.filter { it != '-' && it != ' ' }.lowercase()
 *
 * Tomamos el input y filtramos cada carácter:
 * "lumberjacks" -> no tiene guiones ni espacios -> "lumberjacks"
 * "alejan-dro"  -> eliminamos el guión          -> "alejandro"
 *
 * Luego convertimos a minúscula:
 * "lumberjacks" -> "lumberjacks"  (ya estaba en minúscula)
 * "ALEJAN-DRO"  -> "alejandro"
 */

/**
 * letters.length == letters.toList().distinct().size
 *
 * Convertimos el String a lista de caracteres:
 * "lumberjacks" -> ['l','u','m','b','e','r','j','a','c','k','s']
 * "alejandro"   -> ['a','l','e','j','a','n','d','r','o']
 *
 * Eliminamos duplicados con distinct():
 * "lumberjacks" -> ['l','u','m','b','e','r','j','a','c','k','s'] (sin cambios, 11 elementos)
 * "alejandro"   -> ['a','l','e','j','n','d','r','o']             (se eliminó una 'a', 8 elementos)
 *
 * Comparamos tamaños:
 * "lumberjacks" -> 11 == 11 -> true  (es isograma)
 * "alejandro"   -> 9  == 8  -> false (no es isograma, la 'a' se repite)
 */
