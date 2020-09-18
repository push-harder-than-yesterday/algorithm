function removeNthFromEnd(head, index) {
  index = getSize(head) - index;

  if (!index) {
    head = head.next;
    return head;
  }

  const previous = getAt(head, index - 1);
  const next = previous.next;
  previous.next = next.next;

  return head;
}

function getSize(head) {
  let size = 0;

  while (head) {
    size++;
    head = head.next;
  }

  return size;
}

function getAt(head, index) {
  let count = 0;

  while (head) {
    if (count === index) {
      return head;
    }
    count++;
    head = head.next;
  }

  return null;
}