function connect(root) {
  getLevel(root, 0, []).forEach(tree => {
    tree.forEach((t, i) => {
      if (i !== tree.length - 1) {
        t.next = tree[i + 1];
      }
    })
  })

  return root
};

function getLevel(node, level, answer) {
  if (!node) return answer;

  if (!answer[level]) answer[level] = [];
  if (node.val !== null) answer[level].push(node);

  getLevel(node.left, level + 1, answer);
  getLevel(node.right, level + 1, answer);

  return answer;
}