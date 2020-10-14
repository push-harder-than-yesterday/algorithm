var lengthOfLongestSubstring = function (s) {
	/* 
    #===========================================================# 
    | 접근 방식 1                                               | 
    |-----------------------------------------------------------|
    | 부분 문자열을 저장하는 arr을 따로 선언                    |
    | 만약 부분 문자열 안에 존재하는 문자가 나온다면 현재       |
    | 부분 문자열에서 해당 문자가 나온 위치까지 잘라내고 현재   |
    | 문자를 다시 넣어준다.                                     |
    | 예시  arr: [a,b,c],  비교 문자 : b                        |
    |      => arr: [c, b]                                       |
    #===========================================================#
    */
	let maxCnt = 0;
	let arr = [];

	for (let i = 0; i < s.length; i++) {
		if (arr.includes(s[i])) {
			maxCnt = Math.max(maxCnt, arr.length);
			arr = arr.slice(arr.indexOf(s[i]) + 1);
			arr.push(s[i]);
			continue;
		}
		arr.push(s[i]);
	}

	return Math.max(maxCnt, arr.length);
};
