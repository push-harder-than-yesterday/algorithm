function isPowerOfThree(n) {
  if (n < 1) return false;

  while (!(n % 3)) {
    n /= 3;
  }

  return n === 1;
}

console.log(isPowerOfThree(1))
console.log(isPowerOfThree(27));
console.log(isPowerOfThree(0));
console.log(isPowerOfThree(9));
console.log(isPowerOfThree(45));