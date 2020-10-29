function buildTree(preorder, inorder) {
  if (!preorder || !inorder || !preorder.length || !inorder) {
    return null;
  }

  const root = preorder.shift();
  const node = new TreeNode(root);
  const index = inorder.indexOf(root);

  const iLeft = inorder.slice(0, index);
  const iRight = inorder.slice(index + 1);
  const pLeft = preorder.slice(0, iLeft.length);
  const pRight = preorder.slice(iLeft.length);

  node.left = buildTree(pLeft, iLeft);
  node.right = buildTree(pRight, iRight);

  return node;
}