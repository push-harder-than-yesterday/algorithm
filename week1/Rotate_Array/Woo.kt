package week1.Rotate_Array

/**
 * created by victory_woo on 2020/09/05
 * */
class Woo {
    fun main(args: Array<String>) {
        //rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(intArrayOf(-1, -100, 3, 99), 2)
    }

    private fun rotate(nums: IntArray, k: Int) {
        var count = 0
        var start = 0
        while (count < nums.size) {
            var current = start
            var cache = nums[current]

            do {
                val next = (current + k) % nums.size
                val temp = nums[next]
                nums[next] = cache
                cache = temp
                current = next
                count++
            } while (start != current)
            start++
        }
        for (i in nums) println(i)
    }
}