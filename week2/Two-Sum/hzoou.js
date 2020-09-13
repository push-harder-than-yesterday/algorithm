function twoSum(numbers, target) {
  if (numbers.length === 2) return [0, 1];

  const map = {}
  for (let i = 0; i < numbers.length; i++) {
    const diff = target - numbers[i];
    if (map.hasOwnProperty(diff)) {
      return [map[diff], i];
    }
    map[numbers[i]] = i
  }
}

console.log(twoSum([2, 7, 11, 15], 9))
console.log(twoSum([3, 2, 4], 6))
console.log(twoSum([3, 3], 6))