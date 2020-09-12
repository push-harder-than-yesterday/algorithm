package week2

/**
 * created by victory_woo on 2020/09/08
 * 접근 방법
 * 하나의 숫자를 제외하고 두번 나타나기 때문에 HashMap 을 사용했다.
 * map 을 이용해 저장한 뒤, 나타난 횟수가 1인 값을 반환한다.
 * */
class SingleNumber {
    fun main(args: Array<String>) {
        println(singleNumber(intArrayOf(2, 2, 1)))
        println(singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    }

    private fun singleNumber(nums: IntArray): Int {
        val map = HashMap<Int, Int>()

        for (i in nums) {
            map[i] = map.getOrDefault(i, 0) + 1
        }

        var result = 0
        map.forEach {
            if (it.value == 1) result = it.key
        }

        return result
    }
}