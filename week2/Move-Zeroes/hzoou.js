function moveZeroes(numbers) {
  let length = numbers.length;
  for (let i = 0; i < length; i++) {
    if (!numbers[i]) {
      numbers.splice(i--, 1);
      numbers.push(0);
      length--;
    }
  }

  return numbers;
}

console.log(moveZeroes([0, 1, 0, 3, 12]))
console.log(moveZeroes([0, 0, 1]))