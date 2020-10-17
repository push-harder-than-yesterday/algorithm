function groupAnagrams(strings) {
  const answer = {};

  strings.forEach((string, i) => {
    const sort = string.split("").sort().join("");

    if (answer[sort]) {
      answer[sort].push(strings[i])
    } else {
      answer[sort] = [strings[i]];
    }
  })

  return Object.values(answer)
}

console.log(groupAnagrams(["eat","tea","tan","ate","nat","bat"]))