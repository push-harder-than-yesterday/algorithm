package week1.Remove_Duplicates_from_Sorted_Array

/**
 * created by victory_woo on 2020/09/03
 * */
class Woo {
    fun main(args: Array<String>) {
        println(removeDuplicates(intArrayOf(1, 1, 2)))
    }

    /* 처음 접근 방법
    fun removeDuplicates(nums: IntArray): Int {
        return nums.distinct().toIntArray().size
    }*/

    private fun removeDuplicates(nums: IntArray): Int {
        var index = 0
        val n = nums.size

        if (n == 0 || n == 1) return n
        for (i in 0 until n - 1) {
            if (nums[i] != nums[i + 1]) nums[index++] = nums[i]
        }

        nums[index++] = nums[n - 1]
        return index
    }
}