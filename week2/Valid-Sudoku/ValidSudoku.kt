package week2

/**
 * created by victory_woo on 2020/09/10
 * */
class ValidSudoku {
    fun main(args: Array<String>) {
        println(isValidSudoku(arrayOf(
                charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )))
    }

    private lateinit var map: Array<CharArray>
    private var len: Int = 0
    private fun isValidSudoku(board: Array<CharArray>): Boolean {
        len = board.size
        map = Array(9) { CharArray(9) }

        for (i in 0 until len step 3) {
            for (j in 0 until len step 3) {
                if (!checkBox(i, j, board)) return false
            }
        }

        for (i in 0 until len) {
            if (!checkRow(i, board)) return false
        }

        for (j in 0 until len) {
            if (!checkCol(j, board)) return false
        }

        return true
    }

    private fun checkBox(r: Int, c: Int, board: Array<CharArray>): Boolean {
        val visited = BooleanArray(10)
        for (i in r..r + 2) {
            for (j in c..c + 2) {
                //print("${board[i][j]} ")
                if (board[i][j] == '.') continue

                val value = board[i][j] - '0'

                if (!visited[value]) visited[value] = true
                else return false
            }
            //println()
        }
        //println()
        return true
    }

    private fun checkRow(r: Int, board: Array<CharArray>): Boolean {
        val visited = BooleanArray(10)
        //print("$r 행 = ")
        for (i in 0 until len) {
            //print("${board[r][i]} ")
            if (board[r][i] == '.') continue

            val value = board[r][i] - '0'
            if (!visited[value]) visited[value] = true
            else return false
        }
        //println()
        return true
    }

    private fun checkCol(c: Int, board: Array<CharArray>): Boolean {
        val visited = BooleanArray(10)
        //print("$c 열 = ")
        for (i in 0 until len) {
            //print("${board[i][c]} ")
            if (board[i][c] == '.') continue

            val value = board[i][c] - '0'
            if (!visited[value]) visited[value] = true
            else return false
        }
        //println()
        return true
    }
}