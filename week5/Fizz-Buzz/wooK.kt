package week5.FizzBuzz

/**
 * created by victory_woo on 2020/10/08
 * */
class wooK {
    fun main(args: Array<String>) {
        println(Solution(15).fizzBuzz())
    }

    class Solution(val n: Int) {
        fun fizzBuzz(): List<String> {
            return (1..n).map { check(it) }.toMutableList()
        }

        fun check(n: Int): String {
            return when {
                isFizzBuzz(n) -> "FizzBuzz"
                isFizz(n) -> "Fizz"
                isBuzz(n) -> "Buzz"
                else -> "$n"
            }
        }

        private fun isFizz(n: Int): Boolean {
            return n % 3 == 0
        }

        private fun isBuzz(n: Int): Boolean {
            return n % 5 == 0
        }

        private fun isFizzBuzz(n: Int): Boolean {
            return isFizz(n) and isBuzz(n)
        }
    }
}