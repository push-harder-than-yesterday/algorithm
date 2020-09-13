function intersect(numbers1, numbers2) {
  const answer = [];
  const map1 = getCountingMap(numbers1);
  const map2 = getCountingMap(numbers2)

  Object.keys(map1).forEach(number => {
    const value1 = map1[number];
    const value2 = map2[number];

    if (!value1 || !value2) return;
    const count = value1 > value2 ? value2 : value1;

    for (let i = 0; i < count; i++) {
      answer.push(number)
    }
  })

  return answer;
}

function getCountingMap(numbers) {
  const map = {};

  numbers.forEach(number => {
    if (map[number]) map[number]++
    else map[number] = 1;
  })

  return map
}

console.log(intersect([1, 2, 2, 1], [2, 2]))
console.log(intersect([4, 9, 5], [9, 4, 9, 8, 4]))
console.log(intersect([1, 2, 2, 1], [2]))
console.log(intersect([3, 1, 2], [1, 1]))
