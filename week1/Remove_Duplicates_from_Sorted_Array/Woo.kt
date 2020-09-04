package week1.Remove_Duplicates_from_Sorted_Array

/**
 * created by victory_woo on 2020/09/03
 * 접근 방법
 * 처음에는 중복되는 요소만 제거하여 길이를 반환하면 되는 줄 알았는데 배열을 참조하므로 배열의 구성도 바뀌어야 한다는 걸 알았다.
 * 반복문을 통해 순회하면서 두 원소를 비교한다. 서로 다른 값이 나오게 되면 배열 앞쪽부터 차근 차근 원소를 넣어줌으로써
 * 중복을 제거한 원소를 만들어준다.
 * 그리고 그 길이를 반환한다.
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