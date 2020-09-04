package week1.Best_Time_to_Buy_and_Sell_Stock_II

/**
 * created by victory_woo on 2020/09/03
 * 접근 방법
 * 사실 문제를 보고 생각해봤는데, 풀이가 안떠올랐다.
 * 그래서 답지를 봤는데, 너무 간단하다.
 * 주식 가격을 그래프로 표현하게 되면 떨어지는 곳과 증가하는 곳을 볼 수 있다.
 * 여기서 이익을 가장 크게 내는 값은 결국, 차이가 생기는 부분을 모두 합한 값과 같다는 원리가 나온다.
 * 따라서 a[i-1] < a[i]인 경우에 대해서 차이를 누적하게 된다면 가장 이익을 크게 낼 수 있는 결과를 구할 수 있다.
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