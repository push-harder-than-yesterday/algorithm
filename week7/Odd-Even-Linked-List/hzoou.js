function oddEvenList(head) {
  let odd = head;
  let even = head.next;
  let evens = even;

  while (even && even.next) {
    odd.next = even.next;
    even.next = odd.next.next;

    even = even.next;
    odd = odd.next;
  }

  odd.next = evens;

  return head;
}