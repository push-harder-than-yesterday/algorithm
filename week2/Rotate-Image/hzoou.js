function rotate(matrix) {
  const column = matrix.map((_, index) => matrix.map(board => board[index]));
  const answer = column.map(c => c.reverse());

  for (let i = 0; i < answer.length; i++) {
    matrix[i] = answer[i]
  }

  return matrix
}

function rotate(matrix) {
  const length = matrix.length - 1;

  for (let i = length; i >= 0; i--) {
    const temp = [];
    for (let j = length; j >= 0; j--) {
      temp.push(matrix[j][length - i])
    }
    matrix.push(temp)
  }

  return matrix.splice(0, length + 1);
}


console.log(rotate([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
console.log(rotate([[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]))
console.log(rotate([[1]]))
console.log(rotate([[1, 2], [3, 4]]))