function maxProfit(prices) {
  let min = Infinity;
  let profit = 0;

  for (const price of prices) {
    if (price < min) {
      min = price;
      continue;
    }
    profit = Math.max(profit, price - min);
  }

  return profit;
}