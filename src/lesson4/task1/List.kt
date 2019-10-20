@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import lesson3.task1.digitNumber
import lesson3.task1.isPrime
import lesson3.task1.minDivisor
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var sum = 0.0
    for (element in v) {
        sum += sqr(element)
    }
    return sqrt(sum)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    var sum = 0.0
    var count = 0.0
    for (i in 0 until list.size) {
        sum += list[i]
        count++
    }
    return if (count > 0.0) sum / count
    else count
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val average = mean(list)
    for (i in 0 until list.size) {
        list[i] -= average
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    var c = 0
    for (i in 0 until a.size) {
        c += a[i] * b[i]
    }
    return c
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {
    val def = x.toDouble()
    var sum = 0
    for (i in 0 until p.size) {
        sum += p[i] * def.pow(i).toInt()
    }
    return sum
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
*/
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    if (list.isEmpty()) return list
    var sum = list.first()
    for (i in 1 until list.size) {
        list[i] += sum
        sum += list[i] - sum
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val list = mutableListOf<Int>()
    var num = n
    var factor: Int
    while (num > 1) {
        factor = minDivisor(num)
        list.add(factor)
        num /= factor
    }
    return list
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var num = n
    val result = mutableListOf<Int>()
    var index = 0
    if (num == 0) return listOf(0)
    while (num > 0) {
        result.add((result.size - index), (num % base))
        num /= base
        index++
    }
    return result
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String {
    var num = n
    var result = ""
    if (num == 0) return "0"
    while (num > 0) {
        result += intToChar((num % base))
        num /= base
    }
    return result.reversed()
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var power = 0
    var result = 0

    for (i in (digits.size - 1) downTo 0) {
        result += digits[i] * base.toDouble().pow(power).toInt()
        power++
    }
    return result
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int {
    var power = 0
    var result = 0
    for (i in (str.length - 1) downTo 0) {
        result += charToInt(str[i]) * base.toDouble().pow(power).toInt()
        power++
    }
    return result
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var string = ""
    val th = n / 1000
    val t = n % 100 / 10
    val tTh = n % 100000 / 1000
    if (tTh != 1) {
        if (t != 1) string += russianH(th) + russianT(th) + russianTh(n) + russianThEnding(n) + russianH(n) +
                russianT(n) + russianU(n)
        else string += russianH(th) + russianT(th) + russianTh(n) + russianThEnding(n) + russianH(n) + russianT(n)
    } else {
        if (t != 1) string += russianH(th) + russianT(th) + russianTh(n) + russianThEnding(n) + russianH(n) +
                russianT(n) + russianU(n)
        else string += russianH(th) + russianT(th) + russianTh(n) + russianThEnding(n) + russianH(n) + russianT(n)
    }
    return string.substring(1, string.length)
}

fun russianU(n: Int): String {
    val array = arrayOf("", " один", " два", " три", " четыре", " пять", " шесть", " семь", " восемь", " девять")
    return array[(n % 10)]
}
fun russianT(n: Int): String =
    if (n % 100/ 10 > 0) {
        if (n % 100 / 10 > 1) when (n % 100 / 10) {
            2 -> " двадцать"
            3 -> " тридцать"
            4 -> " сорок"
            5 -> " пятьдесят"
            6 -> " шестьдесят"
            7 -> " семьдесят"
            8 -> " восемьдесят"
            9 -> " девяносто"
            else -> ""
        } else when (n % 10) {
            1 -> " одиннадцать"
            2 -> " двенадцать"
            3 -> " тринадцать"
            4 -> " четырнадцать"
            5 -> " пятнадцать"
            6 -> " шестнадцать"
            7 -> " семнадцать"
            8 -> " восемнадцать"
            9 -> " девятнадцать"
            else -> " десять"
        }
    } else ""

fun russianH(n: Int): String = when (n % 1000 / 100) {
    1 -> " сто"
    2 -> " двести"
    3 -> " триста"
    4 -> " четыреста"
    5 -> " пятьсот"
    6 -> " шестьсот"
    7 -> " семьсот"
    8 -> " восемьсот"
    9 -> " девятьсот"
    else -> ""
}
fun russianTh(n: Int): String =
    if (n % 100000 / 10000 != 1) {
        when ((n % 10000) / 1000) {
            1 -> " одна"
            2 -> " две"
            else -> russianU(((n % 10000) / 1000))
        }
    } else ""

fun russianThEnding(n: Int): String {
    val string = ""
    if (n / 1000 > 1) {
        if ((n % 10000 / 1000 in 2..4) && (n % 100000 / 10000 != 1)) return " тысячи"
        else if (((n % 10000 / 1000) == 1) && (n % 100000 / 10000 != 1)) return " тысяча"
        else return " тысяч"
    } else return string
}


fun charToInt(x: Char): Int {
    val char = x.toInt()
    return if (char > 96) char - 87
    else x.toString().toInt()
}
fun intToChar(x: Int): String {
    val string = ""
    return if (x > 9) string + (x + 87).toChar()
    else string + "$x"
}