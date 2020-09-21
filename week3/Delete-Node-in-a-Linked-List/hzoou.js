function deleteNode(node) {
  const next = node.next;

  node.val = next.val;
  node.next = next.next;
}