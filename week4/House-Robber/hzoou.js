function rob(numbers) {
  const even = numbers.filter((_, index) => !(index % 2));
  const odd = numbers.filter((_, index) => index % 2);

  return Math.max(sum(even), sum(odd));
}

function sum(numbers) {
  return numbers.reduce((acc, cur) => acc + cur, 0);
}

function rob(numbers) {
  let even = 0;
  let odd = 0;

  for (let i = 0; i < numbers.length; i++) {
    if (i % 2) {
      odd = Math.max(even, odd + numbers[i]);
    } else {
      even = Math.max(odd, even + numbers[i]);
    }
  }

  return Math.max(even, odd);
}

console.log(rob([1, 2, 3, 1]));
console.log(rob([2, 7, 9, 3, 1]));
console.log(rob([2, 1, 1, 2]));
console.log(rob([9, 7, 2, 3, 1]));