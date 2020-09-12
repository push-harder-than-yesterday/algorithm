package week2

/**
 * created by victory_woo on 2020/09/10
 * */
class RotateImage {
    fun main(args: Array<String>) {
//        rotate(arrayOf(
//                intArrayOf(1, 2, 3),
//                intArrayOf(4, 5, 6),
//                intArrayOf(7, 8, 9)
//        ))
        rotate(arrayOf(
                intArrayOf(5, 1, 9, 11),
                intArrayOf(2, 4, 8, 10),
                intArrayOf(13, 3, 6, 7),
                intArrayOf(15, 14, 12, 16)))
    }

    private fun rotate(matrix: Array<IntArray>) {
        val list = ArrayList<String>()
        val len = matrix.size
        for (row in matrix) {
            for (value in row.toList()) list.add("$value")
        }

        var count: Int
        var index: Int
        var result: ArrayList<String>

        for (i in 0 until len) {
            count = 1
            index = i
            result = ArrayList<String>().apply { add(list[index]) }
            while (count < len) {
                index += len
                count++
                result.add(list[index])
            }

            var col = 0
            while (0 < count) {
                count--
                matrix[i][col++] = result[count].toInt()
            }
        }

        for (i in 0 until len) {
            for (j in 0 until len) {
                print("${matrix[i][j]} ")
            }
            println()
        }
    }
}