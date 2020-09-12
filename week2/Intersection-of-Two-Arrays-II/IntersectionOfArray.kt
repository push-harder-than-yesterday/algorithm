package week2

/**
 * created by victory_woo on 2020/09/08
 * 첫번째 접근 방법.
 *
 * */
class IntersectionOfArray {
    fun main(args: Array<String>) {
        intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
        intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
        intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2))
        intersect(intArrayOf(1, 2), intArrayOf(1, 1))
        intersect(intArrayOf(1, 2), intArrayOf(2, 1))
    }

    // 첫번째 접근방법.
    // boolean 타입의 visit 배열을 두어 방문한 원소를 체크한다.
    // nums1 의 값이 nums2 에 있는지 확인하고 교집합이 된다면 list 에 추가한 뒤, 방문했음을 체크한다.
    // 찾은 뒤에는 내부 반복문을 break 한다.
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val list = mutableListOf<Int>()

        var visit = BooleanArray(nums2.size)
        for (number in nums1) {
            for (i in nums2.indices) {
                if (!visit[i] && number == nums2[i]) {
                    visit[i] = true
                    list.add(number)
                    break
                }
            }
        }

        println(list)
        return list.toIntArray()
    }

    // 두번째 접근방법.
    // 두 배열 모두 리스트로 변환한다.
    // 순회하면서 list1 의 원소를 list2 가 갖고 있다면 result 에 추가하고 list2 에서는 삭제한다.
    // 이미 확인한 원소는 제외하기 위함!!
/*    private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val list1 = nums1.toMutableList()
        val list2 = nums2.toMutableList()
        val result = mutableListOf<Int>()

        for (a in list1) {
            if (list2.contains(a)) {
                result.add(a)
                list2.remove(a)
            }
        }

        println(result)
        return result.toIntArray()
    }*/
}