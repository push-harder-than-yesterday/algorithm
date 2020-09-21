function isSymmetric(root) {
  if (!root) return true;

  return symmetric(root.left, root.right);
}

function symmetric(node1, node2) {
  if (!node1 && !node2) return true;
  if (!node1 || !node2) return false;
  if (node1.val !== node2.val) return false;
  if (node1.val === node2.val) {
    const inside = symmetric(node1.right, node2.left);
    const outside = symmetric(node1.left, node2.right);
    return !(!inside || !outside);
  }
}