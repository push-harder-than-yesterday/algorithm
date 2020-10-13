function generate(row) {
  if (row == 0) return [];
  if (row === 1) return [[1]];
  const triangles = [[1], [1, 1]];

  for (let i = 2; i < row; i++) {
    const triangle = [];
    const prev = triangles[i - 1];
    for (let j = 0; j < prev.length - 1; j++) {
      triangle.push(prev[j] + prev[j + 1]);
    }
    triangle.unshift(1);
    triangle.push(1);
    triangles.push(triangle);
  }

  return triangles;
}

function generate(row) {
  const triangles = [];

  for (let i = 1; i <= row; i++) {
    const triangle = [];
    for (let j = 0; j < i; j++) {
      if (j === 0 || j === i - 1) {
        triangle.push(1);
      } else {
        const prev = triangles[i - 2];
        triangle.push(prev[j] + prev[j - 1]);
      }
    }
    triangles.push(triangle);
  }

  return triangles;
}

console.log(generate(5));