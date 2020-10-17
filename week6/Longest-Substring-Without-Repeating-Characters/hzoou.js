function lengthOfLongestSubstring(string) {
  let temp = "";
  let answer = 0;

  for (let i = 0; i < string.length; i++) {
    const s = string[i];

    temp = temp.substring(temp.indexOf(s) + 1);
    temp += s;

    if (temp.length > answer) {
      answer = temp.length
    }
  }

  return answer;
}

console.log(lengthOfLongestSubstring("aabaab!bb"))
console.log(lengthOfLongestSubstring("dvdf"))
console.log(lengthOfLongestSubstring("aab"))
console.log(lengthOfLongestSubstring("abcabcbb"))
console.log(lengthOfLongestSubstring("bbbbb"))
console.log(lengthOfLongestSubstring("pwwkew"))
console.log(lengthOfLongestSubstring(""))