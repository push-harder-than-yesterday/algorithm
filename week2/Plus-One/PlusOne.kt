package week2

import java.math.BigInteger

/**
 * created by victory_woo on 2020/09/07
 * */
class PlusOne {
    fun main(args: Array<String>) {
        plusOne(intArrayOf(1, 2, 3))
        plusOne(intArrayOf(4, 3, 2, 1))
        plusOne(intArrayOf(0))
        plusOne(intArrayOf(9))
        plusOne(intArrayOf(9, 9))
        plusOne(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
        plusOne(intArrayOf(7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6))
    }

/*    fun plusOne(digits: IntArray): IntArray {
        val digit = digits.sum()+1

        println(digit)

        val s = digits.joinToString("").split("").toMutableList()
        s.removeAt(0)
        s.removeAt(s.lastIndex)

        val result = s.map { it.toInt() }
                .toIntArray()

        result.forEach { println(it) }
        return result
    }*/

    // 접근 방법
    // 배열의 모든 합을 구한 뒤, 1을 더한다.
    // 이를 String 으로 바꾼 뒤, list 로 변환한다.
    fun plusOne(digits: IntArray): IntArray {
        var sum = BigInteger.ZERO
        digits.forEach { sum = (sum.multiply(10.toBigInteger())).add(it.toBigInteger()) }
        sum = sum.add(1.toBigInteger())

        return mutableListOf<Int>().apply {
            "$sum".forEach { add((it - '0')) }
        }.toIntArray()
    }
}