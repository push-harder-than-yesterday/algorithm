package week2

/**
 * created by victory_woo on 2020/09/08
 * 접근 방법.
 * 배열에 있는 문자열의 길이가 모두 다르기 때문에 가장 짧은 문자열을 기준으로 찾아야 한다고 생각
 * 가장 짧은 길이의 문자열을 찾는다.
 * 이를 제외한 list 구성.
 * 가장 짧은 문자열에서 한글자씩 붙여가면서 list 의 원소들이 prefix 를 포함하는지 확인
 * 포함하지 않는다면 flag 값이 변경되어 sb 객체에 붙이지 못함.
 * 포함한다면 sb 객체에 min[i]를 붙여주는 과정 반복.
 * sb 객체에는 공통으로 존재하는 prefix 가 담기게 된다.
 * */
class LongestCommonPrefix {
    fun main(args: Array<String>) {
        println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
        println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    }

    private fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        // 1. 가장 짧은 친구를 찾아야 한다.
        var min = strs[0]
        for (i in 1 until strs.size) {
            if (strs[i].length < min.length) min = strs[i]
        }

        val list = strs.toMutableList().apply { remove(min) }

        val sb = StringBuilder()
        var prefix = ""
        for (i in min.indices) {
            prefix += min[i]
            var flag = true
            for (str in list) {
                if (!str.startsWith(prefix)) flag = false
            }
            if (flag) sb.append(min[i])
        }
        return sb.toString()
    }
}