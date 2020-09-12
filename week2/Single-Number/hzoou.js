function singleNumber(numbers) {
  const map = {};
  numbers.forEach(number => {
    if (map[number]) map[number]++
    else map[number] = 1;
  })
  const [answer] = Object.keys(map).filter(number => map[number] === 1);

  return answer;
}

console.log(singleNumber([2, 2, 1]))
console.log(singleNumber([4, 1, 2, 1, 2]))
