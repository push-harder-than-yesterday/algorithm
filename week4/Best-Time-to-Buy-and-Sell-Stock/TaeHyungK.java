package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {1,2,4};
        System.out.println("result: " + maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        List<Integer> benefits = new ArrayList<>();

        // 첫번째 풀이
        // for 문을 돌려 각 가격마다 그 뒤에 있는 배열들을 구성하고 해당 배열을 정렬한 후 최댓값을 가져와
        // 현재 가격을 빼준다. 그 값이 benefit이 되기 때문에 benefit을 리스트에 담아 저장하고
        // 최대 benefit을 반환한다.
        for (int i = 0; i < prices.length; i++) {
            int[] afterPrices = Arrays.copyOfRange(prices, i, prices.length);

            Arrays.sort(afterPrices);
            int afterMaxPrice = afterPrices[afterPrices.length - 1]; // 정렬한 후 맨 뒤 값이 max value
            int curPrice = prices[i];

            int benefit = afterMaxPrice - curPrice;
            benefits.add(Math.max(benefit, 0));
        }

        // 위 로직 했는데 음수면 한번도 오르지 않은 것으로
        // 안사는게 가장 큰 이득
        if (benefits.isEmpty()) return 0;

        return Collections.max(benefits);
    }
}
