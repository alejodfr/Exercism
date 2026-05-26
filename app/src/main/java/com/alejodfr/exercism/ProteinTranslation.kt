package com.alejodfr.exercism

/**
 * Instructions
 *
 * Translate RNA sequences into proteins.
 *
 * RNA can be broken into three-nucleotide sequences called codons, and then
 * translated to a protein like so:
 *
 *   RNA: "AUGUUUUCU" => translates to
 *
 *   Codons: "AUG", "UUU", "UCU" => which become a protein with the following
 *   sequence =>
 *
 *   Protein: "Methionine", "Phenylalanine", "Serine"
 *
 * There are 64 codons which in turn correspond to 20 amino acids; however, all
 * of the codon sequences and resulting amino acids are not important in this
 * exercise. If it works for one codon, the program should work for all of them.
 * However, feel free to expand the list in the test suite to include them all.
 *
 * There are also three terminating codons (also known as 'STOP' codons); if any
 * of these codons are encountered (by the ribosome), all translation ends and
 * the protein is terminated.
 *
 * All subsequent codons after are ignored, like this:
 *
 *   RNA: "AUGUUUUCUUAAAUG" =>
 *
 *   Codons: "AUG", "UUU", "UCU", "UAA", "AUG" =>
 *
 *   Protein: "Methionine", "Phenylalanine", "Serine"
 *
 * Note the stop codon "UAA" terminates the translation and the final methionine
 * is not translated into the protein sequence.
 *
 * Below are the codons and resulting amino acids needed for the exercise.
 *
 *   Codon          | Amino Acid
 *   ---------------|-------------
 *   AUG            | Methionine
 *   UUU, UUC       | Phenylalanine
 *   UUA, UUG       | Leucine
 *   UCU, UCC, UCA, UCG | Serine
 *   UAU, UAC       | Tyrosine
 *   UGU, UGC       | Cysteine
 *   UGG            | Tryptophan
 *   UAA, UAG, UGA  | STOP
 */

fun translate(rna: String?): List<String> {
    if (rna == null) return emptyList()
    val splitWord = rna.chunked(3)
    val proteins = mutableListOf<String>()
    for (codon in splitWord){
        val protein = codonToProtein(codon)
        if (protein == "STOP") return proteins
        proteins.add(protein)
    }
    return proteins

}

fun codonToProtein(codon: String): String = when (codon) {
    "AUG"                         -> "Methionine"
    "UUU", "UUC"                  -> "Phenylalanine"
    "UUA", "UUG"                  -> "Leucine"
    "UCU", "UCC", "UCA", "UCG"    -> "Serine"
    "UAU", "UAC"                  -> "Tyrosine"
    "UGU", "UGC"                  -> "Cysteine"
    "UGG"                         -> "Tryptophan"
    "UAA", "UAG", "UGA"           -> "STOP"
    else -> throw IllegalArgumentException("Unknown codon: $codon")
}

fun main() {
    println("Enter an RNA sequence:")
    val rna = readln()

    try {
        val result = translate(rna)
        println(result)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

/**
 * # RNA Translation — Guía de resolución
 *
 * ## Paso 1 — Entender el problema
 *
 * Dado un String de RNA, dividirlo en codones (grupos de 3 letras)
 * y traducir cada uno a su proteína correspondiente.
 * Si se encuentra un codón STOP, detener la traducción.
 *
 * Ejemplo:
 *   "AUGUUUUCU"        -> ["Methionine", "Phenylalanine", "Serine"]
 *   "AUGUUUUCUUAAAUG"  -> ["Methionine", "Phenylalanine", "Serine"]
 *                          (UAA es STOP, se ignora el AUG final)
 *
 * ## Paso 2 — Mapear codones a proteínas con `when`
 *
 * En vez de un Map con 64 entradas repetidas, usamos `when`
 * que permite agrupar varios codones en una sola línea.
 *
 *   fun codonToProtein(codon: String): String = when (codon) {
 *       "AUG"                      -> "Methionine"
 *       "UUU", "UUC"               -> "Phenylalanine"
 *       "UUA", "UUG"               -> "Leucine"
 *       "UCU", "UCC", "UCA", "UCG" -> "Serine"
 *       "UAU", "UAC"               -> "Tyrosine"
 *       "UGU", "UGC"               -> "Cysteine"
 *       "UGG"                      -> "Tryptophan"
 *       "UAA", "UAG", "UGA"        -> "STOP"
 *       else -> throw IllegalArgumentException("Unknown codon: $codon")
 *   }
 *
 * ## Paso 3 — Manejar el null
 *
 * El parámetro `rna: String?` puede ser null.
 * Si es null, retornamos una lista vacía en vez de lanzar excepción,
 * porque un RNA vacío simplemente no produce proteínas.
 *
 *   if (rna == null) return emptyList()
 *
 * ## Paso 4 — Dividir en codones con `chunked()`
 *
 * `chunked(3)` divide el String en grupos de 3 caracteres.
 *
 *   "AUGUUUUCU".chunked(3)  // ["AUG", "UUU", "UCU"]
 *
 * Cada elemento de la lista resultante es un codón de 3 letras.
 *
 * ## Paso 5 — Traducir y manejar el STOP
 *
 * Recorremos la lista de codones con un for.
 * Vamos acumulando proteínas en una lista mutable.
 * Si encontramos un STOP, retornamos inmediatamente lo que llevamos.
 *
 * IMPORTANTE: retornamos la lista de PROTEÍNAS, no de codones.
 * splitWord tiene ["AUG", "UUU"...] pero el resultado debe ser
 * ["Methionine", "Phenylalanine"...]
 *
 *   val proteins = mutableListOf<String>()
 *
 *   for (codon in splitWord) {
 *       val protein = codonToProtein(codon)
 *       if (protein == "STOP") return proteins
 *       proteins.add(protein)
 *   }
 *
 *   return proteins
 *
 * ## Resultado final
 *
 *   fun codonToProtein(codon: String): String = when (codon) {
 *       "AUG"                      -> "Methionine"
 *       "UUU", "UUC"               -> "Phenylalanine"
 *       "UUA", "UUG"               -> "Leucine"
 *       "UCU", "UCC", "UCA", "UCG" -> "Serine"
 *       "UAU", "UAC"               -> "Tyrosine"
 *       "UGU", "UGC"               -> "Cysteine"
 *       "UGG"                      -> "Tryptophan"
 *       "UAA", "UAG", "UGA"        -> "STOP"
 *       else -> throw IllegalArgumentException("Unknown codon: $codon")
 *   }
 *
 *   fun translate(rna: String?): List<String> {
 *       if (rna == null) return emptyList()
 *
 *       val splitWord = rna.chunked(3)
 *       val proteins = mutableListOf<String>()
 *
 *       for (codon in splitWord) {
 *           val protein = codonToProtein(codon)
 *           if (protein == "STOP") return proteins
 *           proteins.add(protein)
 *       }
 *
 *       return proteins
 *   }
 *
 * ## Funciones clave utilizadas
 *
 *   chunked(n)        — divide un String en grupos de n caracteres
 *   when              — mapea valores a resultados, agrupa casos con comas
 *   mutableListOf()   — lista mutable a la que puedes agregar elementos
 *   list.add()        — agrega un elemento al final de la lista
 *   return            — dentro del for, detiene el loop y retorna inmediatamente
 */