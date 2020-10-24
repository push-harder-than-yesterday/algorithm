function getIntersectionNode(headA, headB) {
  const set = new Set();

  while (headA) {
    set.add(headA);
    headA = headA.next
  }

  while (headB) {
    if (set.has(headB)) {
      return headB;
    }
    headB = headB.next
  }

  return null
}