function hasCycle(head) {
  const heads = [];

  while (head) {
    const cycle = heads.includes(head.next);
    if (cycle) return true;
    heads.push(head);
    head = head.next;
  }

  return false;
}

function hasCycle(head) {
  if (!head) return false;
  if (head.cycle) return true;
  head.cycle = true;
  return hasCycle(head.next);
}