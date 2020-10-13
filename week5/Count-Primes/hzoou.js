function countPrimes(n) {
  const prime = new Array(n).fill(0);
  prime[0] = 1;
  prime[1] = 1;

  for (let i = 2; i < n; i++) {
    for (let j = 2; i * j < n; j++) {
      prime[i * j] = 1;
    }
  }

  return prime.filter(n => !n).length;
}

console.log(countPrimes(10))
console.log(countPrimes(2))

