package week1.Reverse_String

/**
 * created by victory_woo on 2020/09/03
 * */
class Woo {
    fun main(args: Array<String>) {
        println(reverseString(charArrayOf('h', 'e', 'l', 'l', 'o')))
    }

    fun reverseString(s: CharArray): Unit {
        val n = s.size
        var start = 0
        var end = n - 1
        for (i in 0 until n / 2) {
            val tmp = s[start]
            s[start] = s[end]
            s[end] = tmp

            start++
            end--
        }
    }
}