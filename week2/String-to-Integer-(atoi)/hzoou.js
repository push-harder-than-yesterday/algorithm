function myAtoi(string) {
  string = string.trim();
  const matched = string.match(/^[+-]?\d+/g);

  if (!matched) return 0;

  const [number] = matched;
  const MIN = -2147483648;
  const MAX = 2147483647;

  if (number > MAX) return MAX;
  if (number < MIN) return MIN;
  return number;
}

function myAtoi(string) {
  const number = parseInt(string.trim(), 10);
  if (isNaN(number)) return 0;

  const MIN = -2147483648;
  const MAX = 2147483647;

  if (number > MAX) return MAX;
  if (number < MIN) return MIN;
  return number;
}


console.log(myAtoi("42"))
console.log(myAtoi("   -42"))
console.log(myAtoi("4193 with words"))
console.log(myAtoi("words and 987"))
console.log(myAtoi("-91283472332"))
console.log(myAtoi("-0"))
console.log(myAtoi("0"))
console.log(myAtoi("-0012a42"))