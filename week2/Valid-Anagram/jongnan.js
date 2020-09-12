var isAnagram = function (s, t) {
	// 처음 접근 방법
	// Map을 사용하여 s의 문자 개수 파악
	// t를 돌면서 s를 저장한 Map을 확인 후 존재하면 -1, 없으면 false 리턴
	// 다 돈 후에도 남아있다면 false 리턴
	// 두번의 for문을 돌으므로 O(N) 시간이 걸림
	if (s.length !== t.length) return false;
	const sMap = new Map();
	s.split('').forEach((char) => {
		if (sMap.has(char)) {
			sMap.set(char, sMap.get(char) + 1);
			return;
		}
		sMap.set(char, 1);
	});
	for (let target of t.split('')) {
		if (!sMap.has(target)) {
			return false;
		}
		const cnt = sMap.get(target) - 1;
		if (cnt === 0) {
			sMap.delete(target);
			continue;
		}
		sMap.set(target, cnt);
	}
	if (sMap.size > 0) return false;
	return true;

	// 다른 접근 방식 (솔루션)
	// 두개의 문자열을 sorting하고 이를 하나씩 비교
	// 두개의 문자열을 sorting 해야하므로 O(NlogN)시간이 걸림
	if (s.length !== t.length) return false;
	const sArr = s.split('').sort();
	const tArr = t.split('').sort();
	for (let i = 0; i < sArr.length; i++) {
		if (sArr[i] !== tArr[i]) return false;
	}
	return true;
};
