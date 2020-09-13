package week2

/**
 * created by victory_woo on 2020/09/06
 * */
class ValidAnagram {
    fun main(args: Array<String>) {
        println(isAnagram("anagram", "nagaram"))
        println(isAnagram("rat", "car"))
    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val a = s.split("").sorted()
        val b = t.split("").sorted()
        a.forEachIndexed { index, s ->
            if (s != b[index]) return false
        }
        return true
    }
}