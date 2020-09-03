/**
 * Constraints:
 * 1 <= prices.length <= 3 * 10 ^ 4 -> 길이가 1이상 30000 이하
 * 0 <= prices[i] <= 10 ^ 4  -> 각 가격은 10000 이하
 */
public class BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {6,1,3,2,4,7};
        System.out.println("benefit: " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int benefit = 0;

        // 첫번째 풀이
        // 떨어지기 직전까지의 값중 가장 싼 값에 구매, 떨어지기 직전에 판매하면 될 듯
        int lastIndex = prices.length - 1;
        int index = 0;
        for (int i = 0; i < lastIndex; i++) {
            System.out.println(i);
            int curIndex = index;
            System.out.println("value: " + prices[i] + " | " + prices[i + 1]);
            if (prices[i] > prices[i + 1]) {
                // 값이 떨어지거나 같다면 이때 팔야아함
                index = i + 1;
            } else if (i == lastIndex - 1 &&
                    prices[index] < prices[lastIndex]) {
                // 마지막 까지 값이 안떨어진 경우
                index = lastIndex + 1;
            }
            System.out.println("index: " + curIndex + " | " + index);

            System.out.println();
            if (curIndex != index) {
                System.out.println("isDown ! " + prices[index - 1] + " - " + prices[curIndex] + " = " + (prices[index - 1] - prices[curIndex]));
                benefit += prices[index - 1] - prices[curIndex];
            }
        }

        // 위 로직 했는데 음수면 한번도 오르지 않은 것으로
        // 안사는게 가장 큰 이득
        if (benefit < 0) benefit = 0;

        return benefit;
    }
}