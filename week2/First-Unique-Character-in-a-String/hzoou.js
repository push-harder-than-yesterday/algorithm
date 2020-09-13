function firstUniqChar(string) {
  const strings = string.split("");

  const map = {};
  strings.forEach(string => {
    if (map[string]) map[string]++
    else map[string] = 1;
  })

  const [answer] = Object.keys(map).filter(number => map[number] === 1);

  return strings.indexOf(answer);
}

console.log(firstUniqChar("leetcode"))
console.log(firstUniqChar("loveleetcode"))