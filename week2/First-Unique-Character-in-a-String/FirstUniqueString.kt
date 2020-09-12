package week2

/**
 * created by victory_woo on 2020/09/07
 * */
class FirstUniqueString {
    fun main(args: Array<String>) {
        println(firstUniqChar("leetcode"))
        println(firstUniqChar("loveleetcode"))
        println(firstUniqChar("aadadaad"))
        println(firstUniqChar("z"))
    }

    // 첫 번째 접근 방법
    // 앞에서부터 문자를 하나씩 기준으로 정한다.
    // 이후, 그 뒤로 존재하는 문자열이 기준으로 잡은 문자를 포함하는지 안하는지 여부로 확인하여 인덱스를 반환한다.
    // aadadaad 와 같은 경우 오답 출력..!
    /*fun firstUniqChar(s: String): Int {
        if (s.length == 1) return 0
        for (i in 0 until s.length - 1) {
            val a = s[i]
            val sub = s.substring(i + 1)
            if (!sub.contains(a)) {
                return i
            }
        }

        return -1
    }*/

    // 두번째 접근 방법
    // HashMap 을 이용하여 주어진 단어에서 문자가 몇 번 등장하는 지 저장한다.
    // 하지만, map 이 순서를 보장하지는 않기 때문에 순서를 보장하는 특징을 가진 LinkedHashMap 을 사용하였다.
    // 그리고 1번만 등장하는 key 를 반환하며 종료한다.
    // 없다면 -1을 반환!
    private fun firstUniqChar(s: String): Int {
        val map = LinkedHashMap<Char, Int>().apply {
            s.forEach { this[it] = this.getOrDefault(it, 0) + 1 }
        }

        for ((key, value) in map) {
            if (value == 1) return s.indexOf(key)
        }

        return -1
    }
}