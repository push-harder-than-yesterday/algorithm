function isPalindrome(string) {
  const strings = string.toLowerCase().match(/[a-z0-9]/g);
  if (!strings) return true;

  const forward = strings.join("");
  const reverse = strings.reverse().join("");

  return forward === reverse
}

console.log(isPalindrome("A man, a plan, a canal: Panama"));
console.log(isPalindrome("race a car"));
console.log(isPalindrome(" "));
console.log(isPalindrome("0P"));
console.log(isPalindrome("***"));
console.log(isPalindrome("**^*"));