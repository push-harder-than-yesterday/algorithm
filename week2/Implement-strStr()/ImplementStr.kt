package week2

/**
 * created by victory_woo on 2020/09/07
 * */
class ImplementStr {
    fun main(args: Array<String>) {
        println(strStr("hello", "ll"))
        println(strStr("aaaaa","baa"))
    }

    private fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0

        return if (haystack.contains(needle)) haystack.indexOf(needle)
        else -1
    }
}