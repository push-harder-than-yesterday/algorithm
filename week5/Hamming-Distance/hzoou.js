function hammingDistance(x, y) {
  return (x ^ y).toString(2).replace(/0/g, '').length;
}

function hammingDistance(x, y) {
  const xor = (x ^ y).toString(2);
  let distance = 0;

  for (const bit of xor) {
    if (bit === "1") distance++;
  }

  return distance
}

console.log(hammingDistance(1, 4));