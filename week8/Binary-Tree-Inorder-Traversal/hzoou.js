function inorderTraversal(root) {
  if (!root) return [];

  const answer = [];
  const traverse = node => {
    if (node.left) traverse(node.left);
    if (node.val) answer.push(node.val);
    if (node.right) traverse(node.right);
  };
  traverse(root);

  return answer;
}

console.log(inorderTraversal([1, null, 2, 3]))