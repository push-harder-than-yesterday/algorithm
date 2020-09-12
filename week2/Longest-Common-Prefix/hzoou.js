function longestCommonPrefix(strings) {
  if (!strings.length || strings.includes("")) return "";

  let index = 0;
  const [base] = strings;
  while (true) {
    if (index === base.length) break;
    const prefix = base.slice(0, index + 1);
    const result = strings.every(string => string.startsWith(prefix));
    if (!result) break;
    index++;
  }

  return base.slice(0, index);
}

console.log(longestCommonPrefix(["flower", "flow", "flight"]))
console.log(longestCommonPrefix(["dog", "racecar", "car"]))
console.log(longestCommonPrefix([""]))
console.log(longestCommonPrefix(["a"]))