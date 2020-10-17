function longestPalindrome(string) {
  let answer = string[0];

  for (let i = 0; i < string.length; i++) {
    const substr = string.substr(i, string.length);

    for (let j = substr.length; j > 1; j--) {
      const superSubstr = substr.substr(0, j);

      if (isPalindrome(superSubstr) && superSubstr.length > answer.length) {
        answer = superSubstr;
      }
    }
  }

  return answer;
}

function isPalindrome(string) {
  let left = 0, right = string.length - 1;

  while (left < right) {
    if (string[left] !== string[right]) {
      return false;
    }
    left++;
    right--;
  }
  return true;
}

console.log(longestPalindrome("abb"));
console.log(longestPalindrome("babad"));
console.log(longestPalindrome("cbbd"));
console.log(longestPalindrome("a"));
console.log(longestPalindrome("ac"));
console.log(longestPalindrome("bacabab"));