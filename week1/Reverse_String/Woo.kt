package week1.Reverse_String

/**
 * created by victory_woo on 2020/09/03
 * 접근 방법
 * 중간점을 기준으로 start, end 를 통해 서로의 위치를 교환해준다.
 * */
class Woo {
    fun main(args: Array<String>) {
        println(reverseString(charArrayOf('h', 'e', 'l', 'l', 'o')))
    }

    fun reverseString(s: CharArray): Unit {
        var start = 0
        var end = n - 1
        for (i in 0 until s.size / 2) {
            val tmp = s[start]
            s[start] = s[end]
            s[end] = tmp

            start++
            end--
        }
    }
}