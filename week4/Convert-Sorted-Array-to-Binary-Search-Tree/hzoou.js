function TreeNode(val, left, right) {
  this.val = (val === undefined ? 0 : val);
  this.left = (left === undefined ? null : left);
  this.right = (right === undefined ? null : right);
  return this;
}

function sortedArrayToBST(numbers) {
  if (!numbers.length) return null;

  const rootIndex = Math.floor(numbers.length / 2);
  const root = new TreeNode(numbers[rootIndex]);
  const left = numbers.slice(0, rootIndex);
  const right = numbers.slice(rootIndex + 1);

  root.left = sortedArrayToBST(left);
  root.right = sortedArrayToBST(right);

  return root;
}

console.log(sortedArrayToBST([-10, -3, 0, 5, 9]));
console.log(sortedArrayToBST([0, 1, 2, 3, 4, 5, 6]));
console.log(sortedArrayToBST([-10, -3, 5, 9]));