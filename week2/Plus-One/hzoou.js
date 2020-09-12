function plusOne(numbers) {
  return ((+numbers.join("") + 1) + "").split("");
}

function plusOne(numbers) {
  const answer = [];
  let carry = 1;

  numbers.reverse().forEach(number => {
    const sum = number + carry;
    answer.unshift(sum % 10);
    carry = Math.floor(sum / 10);
  })

  if (carry) answer.unshift(1);

  return answer;
}

console.log(plusOne([1, 2, 3]))
console.log(plusOne([4, 3, 2, 1]))
console.log(plusOne([0]))
console.log(plusOne([6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3]))
console.log(plusOne([9]))
console.log(plusOne([9, 9]))


