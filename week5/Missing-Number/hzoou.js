function missingNumber(numbers) {
  const length = numbers.length;

  for (let i = 0; i < length; i++) {
    if (!numbers.includes(i)) return i;
  }

  return length;
}

function missingNumber(numbers) {
  const length = numbers.length;
  const sum = length * (length + 1) / 2;
  return numbers.reduce((a, b) => a - b, sum);
}

console.log(missingNumber([3, 0, 1]));
console.log(missingNumber([0, 1]));
console.log(missingNumber([9, 6, 4, 2, 3, 5, 7, 0, 1]));
console.log(missingNumber([0]));