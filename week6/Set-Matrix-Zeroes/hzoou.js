function setZeroes(matrix) {
  const zeroRows = [];
  const zeroColumns = [];

  matrix.forEach((numbers, i) => {
    numbers.forEach((number, j) => {
      if (number === 0) {
        zeroRows.push(i);
        zeroColumns.push(j);
      }
    });
  });

  matrix.forEach((numbers, i) => {
    if (zeroRows.includes(i)) {
      numbers.fill(0);
    }
    numbers.forEach((number, j) => {
      if (zeroColumns.includes(j)) {
        matrix[i][j] = 0;
      }
    });
  });

  return matrix;
}

console.log(setZeroes([[1, 1, 1], [1, 0, 1], [1, 1, 1]]));
console.log(setZeroes([[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]));