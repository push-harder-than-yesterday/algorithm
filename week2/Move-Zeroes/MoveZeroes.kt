package week2

/**
 * created by victory_woo on 2020/09/08
 * 첫번째 접근방법
 * 별도의 배열을 만들어서 할당하는 방법
 *
 * 두번째 접근방법
 * 첫번째 방법을 참고하여 아이디어 발전시킴
 * 0이 아닌 값들을 앞에서 차곡차곡 채움
 * 그리고 index < num.size 동안 뒤에는 0을 채우면 됨.
 * */
class MoveZeroes {
    fun main(args: Array<String>) {
        moveZeroes(intArrayOf(0, 1, 0, 3, 12))
    }


    /*private fun moveZeroes(nums: IntArray): Unit {
        val extra = IntArray(nums.size)
        var index = 0
        for (i in nums) {
            if (i != 0) extra[index++] = i
        }

        for (i in nums) {
            if (i == 0) extra[index++] = i
        }

        extra.forEach { print("$it ") }
        println()
    }*/

    private fun moveZeroes(nums: IntArray) {
        var index = 0
        nums.filter { it != 0 }
                .map { nums[index++] = it }

        while (index < nums.size) {
            nums[index++] = 0
        }

        nums.forEach { println(it) }
    }
}