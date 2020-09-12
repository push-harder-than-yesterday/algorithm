function containsDuplicate(numbers) {
  return numbers.some((num, i) => numbers.indexOf(num) !== i);
}

function containsDuplicate(numbers) {
  const set = new Set(numbers);
  return set.size !== numbers.length;
}

console.log(containsDuplicate([1, 2, 3, 1]))
console.log(containsDuplicate([1, 2, 3, 4]))
console.log(containsDuplicate([1, 1, 1, 3, 3, 4, 3, 2, 4, 2]))