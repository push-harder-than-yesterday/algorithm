function mergeTwoLists(l1, l2) {
  let answer = new ListNode(null);
  let temp = answer;

  while (l1 !== null && l2 !== null) {
    if (l1.val <= l2.val) {
      temp.next = l1;
      l1 = l1.next;
    } else {
      temp.next = l2;
      l2 = l2.next;
    }
    temp = temp.next;
  }

  if (l1 === null) {
    temp.next = l2;
  }
  if (l2 === null) {
    temp.next = l1;
  }

  return answer.next;
}

function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val);
  this.next = (next === undefined ? null : next);
}