function zigzagLevelOrder(root) {
  return getLevel(root, 0, []).map((a, i) => i % 2 ? a.reverse() : a);
}

function getLevel(node, level, answer) {
  if (!node) return answer;

  if (!answer[level]) answer[level] = [];
  if (node.val !== null) answer[level].push(node.val);

  getLevel(node.left, level + 1, answer);
  getLevel(node.right, level + 1, answer);

  return answer;
}