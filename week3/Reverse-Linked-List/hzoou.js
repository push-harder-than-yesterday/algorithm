function reverseList(head) {
  if (!head) return head;

  const nodeList = [];

  while (head.next) {
    nodeList.push(head);
    head = head.next;
  }

  let node = head;

  while (nodeList.length) {
    const previous = nodeList.pop();

    previous.next = null;
    node.next = previous;
    node = node.next;
  }

  return head;
}

function reverseList(node) {
  let head = node;
  let tail = null;

  while (head) {
    let swap = head.next;
    head.next = tail;
    tail = head;
    head = swap;
  }

  return tail;
}

