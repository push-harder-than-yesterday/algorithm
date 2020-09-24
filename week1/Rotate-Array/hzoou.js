function rotate(numbers, k) {
  if (!k) return numbers;
  const length = k % numbers.length;

  for (let i = 0; i < length; i++) {
    const number = numbers.pop();
    numbers.unshift(number);
  }

  return numbers;
}