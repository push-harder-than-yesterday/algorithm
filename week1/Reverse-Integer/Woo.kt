package week1.Reverse_Integer

/**
 * created by victory_woo on 2020/09/03
 * 두 가지 방법이 있다.
 * 1. 문자열로 바꿔서 처리하는 방법
 * StringBuilder를 이용해 문자열 연산을 처리한다.
 * 코틀린 확장 함수인 reversed()를 이용해 뒤집는다.
 * 그리고 결과값이 Int의 범위 사이에 들어오는지 판단하여 값을 반환한다.
 *
 * 2. 숫자로 처리하는 방법
 * 나머지 연산을 이용해서 숫자를 거꾸로 뒤집어준다.
 * Int의 범위 사이에 있는지 판단하여 값을 반환한다.
 *
 * 2번이 1번에 비해 시간이 적게 걸리는 것은 사실이다.
 * 문제를 풀면서 범위를 신경 쓰는게 어려웠다.
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