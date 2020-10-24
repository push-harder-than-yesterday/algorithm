function addTwoNumbers(l1, l2) {
  let l3 = new ListNode(0), carry = 0;
  const result = l3;

  while (l1 || l2) {
    const sum = (l1 ? l1.val : 0) + (l2 ? l2.val : 0) + carry;
    l3.next = new ListNode(sum % 10);
    carry = Math.floor(sum / 10);

    l1 = l1 && l1.next;
    l2 = l2 && l2.next;
    l3 = l3 && l3.next;
  }

  if (carry) {
    l3.next = new ListNode(1)
  }

  return result.next;
}