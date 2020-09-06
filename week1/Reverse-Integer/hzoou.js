function reverse(number) {
  const MIN = -2147483648;
  const MAX = 2147483647;

  const strings = number.toString().split("");
  const isNegative = strings.includes("-");
  const reverseString = strings.reverse().join("");
  const answer = isNegative ? -parseInt(reverseString, 10) : parseInt(reverseString, 10);

  return (answer - MIN) * (answer - MAX) <= 0 ? answer : 0;
}