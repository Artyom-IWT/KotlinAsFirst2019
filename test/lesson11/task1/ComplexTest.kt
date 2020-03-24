package lesson11.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ComplexTest {

    private fun assertApproxEquals(expected: Complex, actual: Complex, eps: Double) {
        assertEquals(expected.re, actual.re, eps)
        assertEquals(expected.im, actual.im, eps)
    }

    @Test
    fun plus() {
        assertApproxEquals(Complex("4-2i"), Complex("1+2i") + Complex("3-4i"), 1e-10)
    }

    @Test
    operator fun unaryMinus() {
        assertApproxEquals(Complex(-2.0, 1.0), -Complex(2.0, -1.0), 1e-10)
    }

    @Test
    fun minus() {
        assertApproxEquals(Complex("-2+6i"), Complex("1+2i") - Complex("3-4i"), 1e-10)
    }

    @Test
    fun times() {
        assertApproxEquals(Complex("11+2i"), Complex("1+2i") * Complex("3-4i"), 1e-10)
    }

    @Test
    fun div() {
        assertApproxEquals(Complex("1+2i"), Complex("11+2i") / Complex("3-4i"), 1e-10)
    }

    @Test
    fun equals() {
        assertApproxEquals(Complex(1.0, 2.0), Complex("1+2i"), 1e-12)
        assertApproxEquals(Complex(1.0, 0.0), Complex(1.0), 1e-12)
    }
    @Test
    fun toStringTest() {
        assertEquals("11.0+2.0i", Complex(11.0, 2.0).toString())
        assertEquals("2.0+i", Complex(2.0, 1.0).toString())
        assertEquals("3.0i", Complex(0.0, 3.0).toString())
        assertEquals("0.0", Complex(0.0, 0.0).toString())
    }
}