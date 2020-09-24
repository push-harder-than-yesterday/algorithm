function isAnagram(string1, string2) {
  const ALPHABET_LENGTH = 26;
  const ASCII = 97;

  if (string1.length !== string2.length) return false;

  const alphabet = new Array(ALPHABET_LENGTH).fill(0);

  for (let i = 0; i < string1.length; i++) {
    alphabet[string1.charCodeAt(i) - ASCII]++;
    alphabet[string2.charCodeAt(i) - ASCII]--;
  }

  return alphabet.every(number => !number)
}

console.log(isAnagram("anagram", "nagaram"))
console.log(isAnagram("rat", "car"))