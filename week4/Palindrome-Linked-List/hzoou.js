function isPalindrome(head) {
  const size = getSize(head);
  const isSizeOdd = !(size % 2);
  let nextIndex = Math.ceil(size / 2);
  let prevIndex = isSizeOdd ? nextIndex - 1 : nextIndex - 2;

  for (let i = nextIndex; i < size; i++) {
    const next = getAt(head, nextIndex++);
    const prev = getAt(head, prevIndex--);

    if (next.val !== prev.val) return false;
  }

  return true;
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