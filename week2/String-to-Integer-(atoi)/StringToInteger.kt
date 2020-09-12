package week2

/**
 * created by victory_woo on 2020/09/10
 * */
class StringToInteger {
    fun main(args: Array<String>) {
        println(myAtoi("42")) // 42
        println(myAtoi("     -42")) // -42
        println(myAtoi("     ")) // 0
        println(myAtoi("word ans 42")) // 0
        println(myAtoi("4193 with words")) // 4193
        println(myAtoi("-91283472332")) // Int.MIN_VALUE
        println(myAtoi("+1")) // 1
        println(myAtoi("   +0 123")) //0
    }

    fun myAtoi(str: String): Int {
        val converted = str.trim()
        println(converted)
        println(str.trim())

        if (converted.isEmpty()) return 0

        var isNegative = false
        var index = 0
        if (converted[0] == '-') {
            isNegative = true
            index++
        } else if (converted[0] == '+') {
            index++
        }

        var result = 0.0
        while (index < converted.length && converted[index].isDigit()) {
            result = (result * 10) + (converted[index] - '0')
            index++
        }

        if (isNegative) result = -result

        if (Int.MAX_VALUE < result) return Int.MAX_VALUE

        if (result < Int.MIN_VALUE) return Int.MIN_VALUE

        return result.toInt()
    }
}