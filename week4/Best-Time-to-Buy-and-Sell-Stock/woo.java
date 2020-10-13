package week4.BestTimeBuyandSellStock;

/**
 * created by victory_woo on 2020/09/24
 */
public class woo {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    /*public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int min = prices[0], minIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
        }

        int profit = 0;
        for (int i = minIndex; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }*/

    // 두 번째 접근 방법.
    /*public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) profit = prices[j] - prices[i];

                max = Math.max(max, profit);
            }
        }
        return max;
    }*/

    // Solution!
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i=0;i<prices.length;i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            } else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
