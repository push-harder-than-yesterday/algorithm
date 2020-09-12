package week2

/**
 * created by victory_woo on 2020/09/06
 * */
class ValidPalindrome {
    fun main(args: Array<String>) {
        println(isPalindrome("A man, a plan, a canal: Panama"))
        println(isPalindrome("race a car"))
        println(isPalindrome("0P"))
        println(isPalindrome("a"))
        println(isPalindrome("1b1"))
        println(isPalindrome("a."))
    }

    fun isPalindrome(s: String): Boolean {
        if (s.length == 1) return true

        val original = s.filter { it.isLetterOrDigit() }.toLowerCase()

        val end = original.length - 1

        (0 until original.length / 2).forEach {
            if (original[it] != original[end - it]) return false
        }
        return true
    }
}