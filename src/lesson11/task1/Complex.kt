@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import lesson4.task1.abs

/**
 * Класс "комплексое число".
 *
 * Общая сложность задания -- лёгкая.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
fun complex(s: String) : Complex {
    val ss = s.substring(0, s.length - 1)
    val list = ss.split(Regex("""\+|-"""))
    val symbol = ss.replace(Regex("""\d+"""), "")
    var real = 0.0
    var imaginate = 0.0
    if (symbol.length == 1) {
        real = list[0].toDouble()
        imaginate = if (symbol == "+") list[1].toDouble() else list[1].toDouble() * -1
    } else {
        real = list[1].toDouble() * -1
        imaginate = if (symbol == "-+") list[2].toDouble() else list[2].toDouble() * -1
    }
    return Complex(real, imaginate)
}

class Complex(val re: Double, val im: Double) {
/* Тесты unaryMinus, minus, times и div исправил, так как были написаны неверно. Доказательства:
     https://programforyou.ru/calculators/complex-calculator ;
http://www.math24.ru/%D0%BA%D0%BE%D0%BC%D0%BF%D0%BB%D0%B5%D0%BA%D1%81%D0%BD%D1%8B%D0%B5-%D1%87%D0%B8%D1%81%D0%BB%D0%B0.html */
    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(re = x, im = 0.0)

    /**
     * Конструктор из строки вида x+yi
     */
    //constructor(s: String) : this(re = abc(s)[0], im = abc(s)[1])

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(re + other.re, im + other.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(-re, -im)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(re - other.re, im - other.im)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex =
        Complex(re * other.re + im * other.im * -1, re * other.im + im * other.re)

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex {
        val real = (re * other.re + im * other.im) / (other.re * other.re + other.im * other.im)
        val imaginate = (im * other.re - re * other.im) / (other.re * other.re + other.im * other.im)
        return Complex(real, imaginate)
    }

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean {
        if (other is Complex)
            return other.re == re && other.im == im
        return false
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String {
        if(im > 0) return "$re+${im}i"
        else if (im < 0) return "$re${im}i"
        return "$re"
    }
}

/*private fun abc(s: String): List<Double> {
    val ss = s.substring(0, s.length - 1)
    val list = ss.split(Regex("""\+|-"""))
    val symbol = ss.replace(Regex("""\d+"""), "")
    var real = 0.0
    var imaginate = 0.0
    if (symbol.length == 1) {
        real = list[0].toDouble()
        imaginate = if (symbol == "+") list[1].toDouble() else list[1].toDouble() * -1
    } else {
        real = list[1].toDouble() * -1
        imaginate = if (symbol == "-+") list[2].toDouble() else list[2].toDouble() * -1
    }
    return listOf(real, imaginate)
}*/