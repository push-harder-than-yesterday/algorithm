function rotate(numbers, k) {
  if (!k) return numbers;

  for (let i = 0; i < k; i++) {
    const number = numbers.pop();
    numbers.unshift(number);
  }

  return numbers;
}