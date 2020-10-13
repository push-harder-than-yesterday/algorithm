function climbStairs(n) {
  const cache = [1, 1];
  
  for (let i = 2; i <= n; i++) {
    cache.push(cache[i - 1] + cache[i - 2]);
  }

  return cache[n];
}

console.log(climbStairs(6))