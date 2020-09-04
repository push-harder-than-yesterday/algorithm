package week1.Reverse_Integer

/**
 * created by victory_woo on 2020/09/03
 * */
class Woo {
    fun main(args: Array<String>) {
        println(reverseWithNumber(123))
        println(reverseWithNumber(-123))
        println(reverseWithNumber(120))
        //println(reverse(9656324351))
    }

    private fun reverse(x: Int): Int {
        val isNegative = x < 0
        if (x == 0) return 0

        val sb = StringBuilder()
        if (isNegative) sb.append('-')

        val s = sb.append(x.toString().reversed()).toString()
        val result = if (isNegative) s.substring(0, s.length - 1).toLong()
        else s.toLong()

        if (result < Int.MIN_VALUE || result > Int.MAX_VALUE) return 0

        return result.toInt()
    }

    private fun reverseWithNumber(x: Int): Int {
        var num = x
        if (x == 0) return 0

        var result = 0L
        while (num != 0) {
            val mod = num % 10
            num /= 10
            result = (result * 10) + mod
        }

        if (result < Int.MIN_VALUE || Int . MAX_VALUE < result) return 0

        return result.toInt()
    }
}