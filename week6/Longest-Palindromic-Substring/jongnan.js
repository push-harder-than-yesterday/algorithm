var longestPalindrome = function (s) {
	/* 
    #===========================================================# 
    | 접근 방식 1                                               | 
    |-----------------------------------------------------------|
    | 문자열의 0번째 문자부터 각 문자열에서 가장 긴 펠린드롬을  | 
    | 찾기 시작                                                 |
    | 즉, 0 ~ s.length - 1, 0 ~ s.length - 2 ... 식으로 찾음    |
    | 문자열의 최대 길이가 1000, 해당 알고리즘은 O(N^3) 이므로  |
    | 최대 10^9 의 시간이 걸릴 것으로 예상                      |
    #===========================================================#
    */
	let pal = s[0];
	for (let i = 0; i < s.length; i++) {
		let last = s.length - 1;
		while (last > i) {
			const subStr = s.substring(i, last + 1);
			if (isPalindrome(subStr)) {
				if (pal.length < subStr.length) pal = subStr;
			}
			last--;
		}
	}
	return pal;

	/* 
    #===========================================================# 
    | 솔루션 방식 1                                             | 
    |-----------------------------------------------------------|
    | Manacher's Algorithm 이란 것이 있는데 이해가 가지 않음;;  |
    #===========================================================#
    */
};

var isPalindrome = function (s) {
	let l = 0,
		r = s.length - 1;
	while (l < r) {
		if (s[l] !== s[r]) return false;
		l++;
		r--;
	}
	return true;
};
