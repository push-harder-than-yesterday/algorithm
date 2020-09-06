function maxProfit(prices) {
  if (isAscending(prices)) {
    return prices[prices.length - 1] - prices[0];
  }

  if (isDescending(prices)) {
    return 0;
  }

  let min = -1, answer = 0;

  for (let i = 0; i < prices.length - 1; i++) {
    if (prices[i] < prices[i + 1]) {
      if (min === -1 || min > prices[i]) {
        min = prices[i];
      }
    } else if (min !== -1) {
      answer += prices[i] - min;
      min = -1;
    }
  }

  if (min !== -1 && min < prices[prices.length - 1]) {
    answer += prices[prices.length - 1] - min;
  }

  return answer;
}

function isAscending(numbers) {
  return numbers.every((number, i) => i === 0 || number >= numbers[i - 1]);
}

function isDescending(numbers) {
  return numbers.every((number, i) => i === 0 || number <= numbers[i - 1]);
}
