function maxDepth(root) {
  return getMaxDepth(root, 1);
}

function getMaxDepth(root, num) {
  if (root === null) {
    return 0;
  }
  if (root.right === null && root.left === null) {
    return num;
  }
  if (root.right && root.left) {
    return Math.max(getMaxDepth(root.right, num + 1), getMaxDepth(root.left, num + 1));
  }
  if (root.right !== null) {
    return getMaxDepth(root.right, num + 1);
  }
  return getMaxDepth(root.left, num + 1);
}