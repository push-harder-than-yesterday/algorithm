function kthSmallest(root, k) {
  return inorder(root, [])[k - 1]
};


function inorder(node, answer) {
  if (!node) return answer;

  inorder(node.left, answer);
  answer.push(node.val);
  inorder(node.right, answer);

  return answer;
}
