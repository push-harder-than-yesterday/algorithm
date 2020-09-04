package week1.Rotate_Array

/**
 * created by victory_woo on 2020/09/05
 * 접근 방법
 * 처음에는 do ~ while문 하나로 처리하려고 했다. 하지만, 5개 정도 틀려서 답을 참고하였다.
 * 두 번째 테케 같은 경우가 문제였다. 배열의 길이가 짝수이고, k도 짝수가 나오게 되면 나누어 떨어지는 경우가 여러번 생기게 되어
 * 똑같은 위치에 중복하여 접근하게 된다. 따라서 이때는 확인하는 칸을 옮겨줘야 하므로 start 변수를 두어 중복하여 방문하게 되면
 * 반복문을 종료하고 start를 증가시켜준다. 또한, 결과를 찾을 때까지 반복해야 하기 때문에
 * 배열의 갯수만큼 반복하여 모든 배열의 원소가 모두 k만큼 이동할때까지 반복한다.
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