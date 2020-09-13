package week2

/**
 * created by victory_woo on 2020/09/08
 * 첫번째 방법
 * 완전 탐색으로 진행. -> 236ms
 *
 * 두번째 방법
 * HashMap 을 사용하여 풀 수 있음. -> 184ms
 * */
class TwoSum {
    fun main(args: Array<String>) {
        //twoSum(intArrayOf(2, 7, 11, 15), target = 9)
        twoSum(intArrayOf(3, 2, 4), target = 6)
    }

    /*private fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        var flag = false
        for (i in nums.indices) {
            for (j in (i + 1) until nums.size) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i
                    result[1] = j
                    flag = true
                    break
                }
            }
            if (flag) break
        }
        result.forEach { println(it) }
        return result
    }*/

    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }

            map[nums[i]] = i
        }

        throw IllegalArgumentException("No Solution")
    }
}