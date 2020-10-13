function merge(numbers, m, numbers2, n) {
  numbers.splice(m, n, ...numbers2);
  numbers = numbers.sort((a, b) => a - b);
  return numbers;
}

function merge(numbers1, m, numbers2, n) {
  let i = 0, j = 0;

  while (j < n) {
    if (numbers1[i] > numbers2[j] || i >= m + j) {
      numbers1.splice(i, 0, numbers2[j]);
      j++;
    }
    i++;
  }

  numbers1.splice(m + n);
  return numbers1;
}

console.log(merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3));
console.log(merge([2, 3, 4, 0, 0, 0], 3, [2, 5, 6], 3));
console.log(merge([4, 5, 6, 0, 0, 0], 3, [1, 2, 3], 3));
