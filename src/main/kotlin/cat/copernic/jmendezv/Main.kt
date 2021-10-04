package cat.copernic.jmendezv

import java.lang.ArithmeticException
import java.lang.IllegalArgumentException
import kotlin.math.pow

/**
 * El máximo de dos números
 */
fun maximo(a: Int, b: Int): Int = if (a > b) a else b

/**
 * Interes simmple = crt
 * c Capital
 * r Tasa de interés en %
 * t tiempo en años
 */
fun interesSimple(c: Double, r: Double, t: Int): Double = c * r * t

/**
 * Interés compuesto = c (1 + r) ^ t
 * c Capital
 * r Tasa de interés en %
 * t tiempo en años
 */
fun interesCompuesto(c: Double, r: Double, t: Int) = c * (1 + r).pow(t)

/**
 * El elemento más pequeño de nums
 *
 * eg: [2,3,1,4,5,1] = 1
 * eg: [] = IllegalArgumentException
 */
fun minimo(nums: Array<Int>): Int =
    if (nums.isNotEmpty()) nums.sortedArray()[0] else throw IllegalArgumentException()

/**
 * La media de nums
 *
 * eg: [1,5,6] = 4.0
 * eg: [] = 0
 */
fun media(nums: Array<Int>): Double = nums.average()

/**
 * El elemento central de nums (nums debe estar ordenado)
 *
 * Si hay un número impar de elementos:
 * eg: [1,2,3] = 2
 *
 * Si hay un número par de elementos:
 * eg: [1,2,3,4] = (2 + 3) / 2 = 2.5
 *
 * eg: [] = 0
 */
fun mediana(nums: Array<Int>): Double {
    if (nums.isEmpty()) return 0.0
    val numsSorted = nums.sortedArray()
    val N = numsSorted.size
    return if (N % 2 == 1)
        numsSorted[N / 2].toDouble()
    else
        (numsSorted[N / 2 - 1] + numsSorted[N / 2]) / 2.0
}

/**
 * El elemento más repetido
 *
 * eg: [2,3,4,2,5,2,3,3,2] = 2
 * eg: [2,3,4,5,2,3,3,2,3] = 2 // Si dos elementos se repiten por igual el menor
 * eg: [] = IllegalArgumentException
 *
 */
fun masRepetido(nums: Array<Int>) = nums.groupBy { it }
    .maxByOrNull { it.value.size }?.key ?: throw IllegalArgumentException()


fun division(a: Double, b: Double) = if (b == 0.0)
    throw ArithmeticException()
else
    a / b

fun ordenaArray(a: Array<Int>) = a.sortedArray()

fun main() {
}