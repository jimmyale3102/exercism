package dev.alejo.exercism

import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean = input.toString()
        .map { char -> char.digitToInt().toDouble().pow(input.toString().length).toInt() }
        .sum() == input

}
