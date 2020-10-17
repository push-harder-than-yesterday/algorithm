function threeSum(numbers) {
  const answers = [];

  for (let i = 0; i < numbers.length; i++) {
    const number = numbers[i];
    const target = 0 - number;
    const filtered = getArrayExceptIndex(numbers, i);
    const answer = twoSum(filtered, target);

    if (answer.length) {
      answer.forEach(a => answers.push([number, ...a]));
    }
  }

  const sorted = answers.map(answer => answer.sort()).sort((a, b) => (a[0] - b[0]) || (a[1] - b[1])).map(a => JSON.stringify(a));
  return sorted.filter((item, i) => sorted.indexOf(item) === i).map(item => JSON.parse(item));
}

function twoSum(numbers, target) {
  const map = {};
  const answer = [];
  for (let i = 0; i < numbers.length; i++) {
    const diff = target - numbers[i];
    if (map.hasOwnProperty(diff)) {
      answer.push([diff, numbers[i]]);
    }
    map[numbers[i]] = i;
  }
  return answer;
}

function getArrayExceptIndex(array, index) {
  return array.filter((_, i) => i > index);
}

console.log("---------------------------------------------------");

function threeSum(numbers) {
  const answers = [];
  numbers.sort((a, b) => a - b);

  if (numbers.length < 3) return answers;
  if (numbers.filter(n => !n).length >= 3) answers.push([0, 0, 0]);

  for (let i = 0; i < numbers.length; i++) {
    const number = numbers[i];

    if (number >= 0) break;
    if (numbers.indexOf(number) !== i) continue;
    if (numbers[i] === numbers[i - 1]) continue;

    const map = {};
    for (let j = i + 1; j < numbers.length; j++) {
      const diff = 0 - number - numbers[j];
      if (map.hasOwnProperty(diff) && numbers[j] !== numbers[j + 1]) {
        answers.push([numbers[i], diff, numbers[j]]);
      }
      map[numbers[j]] = j;
    }
  }

  return answers;
}

console.log("---------------------------------------------------");

function threeSum(numbers) {
  const answers = [];
  numbers.sort((a, b) => a - b);

  if (numbers.length < 3) return answers;
  if (numbers.filter(n => !n).length >= 3) answers.push([0, 0, 0]);

  for (let i = 0; i < numbers.length; i++) {
    const number = numbers[i];

    if (number >= 0) break;
    if (numbers.indexOf(number) !== i) continue;
    if (numbers[i] === numbers[i - 1]) continue;

    let k = numbers.length - 1;

    for (let j = i + 1; j < k; j++) {
      if (number + numbers[j] + numbers[k] === 0) {
        answers.push([number, numbers[j], numbers[k]]);
        while (numbers[j] === numbers[j + 1]) j++;
        while (numbers[k] === numbers[k - 1]) k--;
        k--;
      } else if (number + numbers[j] + numbers[k] > 0) {
        k--;
        j--;
      }
    }
  }

  return answers;
}

// console.log(threeSum([-1, 0, 1, 2, -1, -4]));
console.log(threeSum([-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4]));
// console.log(threeSum([-2, 0, 0, 2, 2]));
// console.log(threeSum([-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6]));
// console.log(threeSum([-2, 0, 1, 1, 2]));
// console.log(threeSum([3, 0, -2, -1, 1, 2]));