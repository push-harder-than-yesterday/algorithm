function countAndSay(n) {
  let answer = "1";

  let i = 0;
  while (i++ < n - 1) {
    const temp = [];
    const counts = [];
    let count = 1;
    for (let j = 0; j < answer.length; j++) {
      if (answer.charAt(j) === answer.charAt(j + 1)) {
        count++;
      } else {
        counts.push(count);
        temp.push(answer.charAt(j));
        count = 1;
      }
    }

    answer = temp.reduce((acc, cur, i) => acc + `${counts[i]}${cur}`, '')
  }

  return answer;
}

function countAndSay(n) {
  return getAnswer(1, n, '1')
}

function getAnswer(start, end, answer) {
  if (start === end) return answer;

  let count = 1, result = '';
  for (let i = 0; i < answer.length; i++) {
    if (answer.charAt(i) === answer.charAt(i + 1)) {
      count++;
    } else {
      result += count + answer.charAt(i)
      count = 1;
    }
  }

  return getAnswer(++start, end, result);
}

console.log(countAndSay(1)) //1
console.log(countAndSay(2)) //11
console.log(countAndSay(3)) //21
console.log(countAndSay(4)) //1211
console.log(countAndSay(5)) //111221
console.log(countAndSay(6)) //312211
console.log(countAndSay(7)) //13112221
console.log(countAndSay(8)) //1113213211
console.log(countAndSay(9)) //31131211131221
