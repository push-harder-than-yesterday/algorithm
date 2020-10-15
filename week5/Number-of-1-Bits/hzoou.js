function hammingWeight(n) {
  return n.toString(2).split("").filter(n => +n).length;
}

console.log(hammingWeight(00000000000000000000000000001011))
console.log(hammingWeight(00000000000000000000000010000000))
console.log(hammingWeight(11111111111111111111111111111101))