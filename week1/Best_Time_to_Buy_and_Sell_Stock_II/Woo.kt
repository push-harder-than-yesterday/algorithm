package week1.Best_Time_to_Buy_and_Sell_Stock_II

/**
 * created by victory_woo on 2020/09/03
 * */
class Woo {
    fun main(args: Array<String>) {
        println(maxProfit(intArrayOf(1, 7, 2, 3, 6, 7, 6, 7)))
        println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        println(maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    }

    private fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 1 until prices.size) {
            if (prices[i - 1] < prices[i]) profit += (prices[i] - prices[i - 1])
        }
        return profit
    }
}