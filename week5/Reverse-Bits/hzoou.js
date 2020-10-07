function reverseBits(n) {
  const binary = n.toString(2).padStart(32, "0");
  return parseInt([...binary].reverse().join(""), 2);
}

console.log(reverseBits(43261596));
console.log(reverseBits(4294967293));