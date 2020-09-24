var strStr = function (haystack, needle) {
	// 처음 접근 방법
	// haystack를 배열로 만들고 needle의 첫번째 문자와 같은 위치를 찾기
	// 찾았다면, needle과 길이가 같은 문자열로 만들고 비교
	if (needle.length === 0) return 0;

	const haystackArr = haystack.split('');

	for (let i = 0; i < haystackArr.length; i++) {
		if (haystackArr[i] !== needle[0]) continue;
		const haystackStr = haystackArr.slice(i, i + needle.length).join('');
		if (haystackStr === needle) return i;
	}
	return -1;
};
