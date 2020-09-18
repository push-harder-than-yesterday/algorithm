function levelOrder(root) {
  const answer = [];
  getLevel(root, 0, answer);
  return answer;
}

function getLevel(node, level, answer) {
  if (!node) return;

  if (!answer[level]) answer[level] = [];
  answer[level].push(node.val);

  getLevel(node.left, level + 1, answer);
  getLevel(node.right, level + 1, answer);
}
