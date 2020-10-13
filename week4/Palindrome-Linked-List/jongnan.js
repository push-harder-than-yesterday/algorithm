/* 
#============================================================# 
| 처음 접근 방식                                             | 
|------------------------------------------------------------|
| 팰린드롬은 현재 노드의 반대편에 있는 노드를 확인           |
| 노드들을 한번씩 방문하면서 이전 노드에는 무엇이있는지 저장 |
| 두개의 포인터(시작, 끝)를 사용하여 팰린드롬인지 확인       |
#============================================================# 
*/
var isPalindrome = function (head) {
	if (head === null) return true;
	let i = 0,
		j = 0;
	let cur = head;
	let prev = null;
	while (cur.next !== null) {
		cur.prev = prev;
		prev = cur;
		cur = cur.next;
		j++;
	}
	cur.prev = prev;

	let front = head;
	let end = cur;
	while (i < j) {
		if (front.val !== end.val) return false;
		i++;
		j--;
		front = front.next;
		end = end.prev;
	}
	return true;
};
