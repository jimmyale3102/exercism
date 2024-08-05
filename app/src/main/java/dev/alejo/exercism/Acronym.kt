package dev.alejo.exercism

object Acronym {
    fun generate(phrase: String) : String = phrase
        .split(" ", "-", "_")
        .filter { it.isNotBlank() }.joinToString("") { it[0].uppercase() }
}