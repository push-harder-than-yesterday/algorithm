function maxSubArray(numbers) {
  if (numbers.every(number => number < 0)) {
    return Math.max.apply(null, numbers);
  }

  let max = -Infinity, sum = 0;
  numbers.forEach(number => {
    sum += number;

    if (sum < 0) {
      sum = 0;
    }
    if (sum > max) {
      max = sum;
    }
  });
  return Math.max(sum, max);
}