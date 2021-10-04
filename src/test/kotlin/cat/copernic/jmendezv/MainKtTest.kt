package cat.copernic.jmendezv

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.ArithmeticException
import java.time.Duration

internal class MainKtTest {
    val array1 = arrayOf(2,3,4,9,4,5,6,2,3,1,4,1)
    val array2 = arrayOf(1,2,3)
    val array3 = arrayOf(1,2,3,4)
    val array4 = arrayOf(6)
    val array5 = arrayOf(4,6)

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun maximo() {
        assertEquals(9, cat.copernic.jmendezv.maximo(9,1))
    }

    @ParameterizedTest
    @CsvSource("1,1,1", "3,2,3", "9,3,9")
    fun maximo2(a: Int, b: Int, c: Int) {
        assertEquals(c, cat.copernic.jmendezv.maximo(a,b))
    }

    @Test
    fun interesSimple() {
        assertEquals(30.0, cat.copernic.jmendezv.interesSimple(1_000.0, 0.01, 3), 1.0e-3)
    }

    @ParameterizedTest
    @CsvSource("1_000.0,0.01,1,10.0", "2_000.0,0.015,1,30.0", "3_000.0,0.01,2,60.0")
    fun interesSimpleTest(c: Double, r: Double, y: Int, t: Double) {
        assertEquals(t, cat.copernic.jmendezv.interesSimple(c,r,y), 1.0e-1)
    }

    @Test
    fun interesCompuesto() {
        assertEquals(1030.301, cat.copernic.jmendezv.interesCompuesto(1_000.0, 0.01, 3), 1.0e-3)
    }

    @Test
    fun minimoTest() {
        assertTimeout(Duration.ofMillis(100)) {
            assertEquals(1, cat.copernic.jmendezv.minimo(array1))
        }

    }

    @Test
    fun media() {
        assertEquals(3.666, cat.copernic.jmendezv.media(array1), 1.0e-3)
    }

    @Test
    fun mediana() {
        assertEquals(3.5, cat.copernic.jmendezv.mediana(array1), 1.0e-3)
        assertEquals(2.0, cat.copernic.jmendezv.mediana(array2), 1.0e-3)
        assertEquals(2.5, cat.copernic.jmendezv.mediana(array3), 1.0e-3)
        assertEquals(6.0, cat.copernic.jmendezv.mediana(array4), 1.0e-3)
        assertEquals(5.0, cat.copernic.jmendezv.mediana(array5), 1.0e-3)
    }

    @Test
    fun masRepetido() {
        assertEquals(4, cat.copernic.jmendezv.masRepetido(array1))
    }

    @Test
    fun divisionTest() {
        org.junit.jupiter.api.assertThrows<ArithmeticException> {
            division(3.0,0.0)
        }
    }

    @Test
    fun ordenaTest() {
        assertArrayEquals(arrayOf(1,2,3,4,5), ordenaArray(arrayOf(2,1,3,5,4)))
    }
}