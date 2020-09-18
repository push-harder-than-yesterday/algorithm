function isValidBST(node) {
  return validate(node, -Infinity, Infinity);
}

function validate(node, min, max) {
  if (node == null) {
    return true;
  }
  if (node.val <= min || node.val >= max) {
    return false;
  }
  if (!validate(node.left, min, node.val) || !validate(node.right, node.val, max)) {
    return false;
  }
  return true;
}