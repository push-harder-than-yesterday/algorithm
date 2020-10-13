function MinStack() {
  this.stack = [];
  this.min = [];
  this.length = 0;
}

MinStack.prototype.push = function (x) {
  const pop = this.min[this.length - 1];
  const min = x > pop ? pop : x;

  // 직접 구현
  this.stack = this.stack.concat(x);
  this.min = this.min.concat(min);

  // Arrays method 사용
  this.stack.push(x)
  this.min.push(min)

  this.length++;
};

MinStack.prototype.pop = function () {
  // 직접 구현
  this.stack = this.stack.slice(0, this.length - 1);
  this.min = this.min.slice(0, this.length - 1);

  // Arrays method 사용
  this.stack.pop()
  this.min.pop()

  this.length--;
};

MinStack.prototype.top = function () {
  return this.stack[this.stack.length - 1];
};

MinStack.prototype.getMin = function () {
  return this.min[this.stack.length - 1];
};

const minStack = new MinStack();
console.log(minStack.push(0));
console.log(minStack.push(1));
console.log(minStack.push(0));
console.log(minStack.getMin()); // return -3
console.log(minStack.pop());
console.log(minStack.getMin()); // return -2

