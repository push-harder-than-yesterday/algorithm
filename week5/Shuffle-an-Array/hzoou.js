function Solution(numbers) {
  this.numbers = numbers;
}

Solution.prototype.reset = function() {
  return this.numbers;
};

Solution.prototype.shuffle = function() {
  const array = this.numbers.slice();

  for (let i = 0; i < array.length; i++) {
    const temp = array[i];
    const j = Math.floor(Math.random() * array.length);
    array[i] = array[j];
    array[j] = temp;
  }

  return array;
};

const solution = new Solution([1, 2, 3]);
solution.shuffle();
solution.reset();
solution.shuffle();