var threeSum = function (nums) {
	/* 
    #===========================================================# 
    | 접근 방식 1                                               | 
    |-----------------------------------------------------------|
    | 2Sum과 동일하게 hashMap을 사용해서 풀려했지만 오히려      |
    | 시간초과 때문에 포기                                      |
    |                                                           |
    | 구글링을 한 결과 two pointer를 사용하여 풀이              |
    | nums를 오름차순으로 설정한 뒤 값을 하나씩 선택            |
    | 이후 선택된 값의 인덱스보다 큰 값들에서 맨 처음을 s       |
    | 마지막을 e로 설정하고 s+e 가 선택된 값 * -1 과 같은지 판별|
    |                                                           |
    | [-4, -1, -1, 0, 1, 2] 일 때 -4를 선택                     |
    |  cur  s            e                                      |
    |                                                           |
    | 만약 s + e의 값이 -cur 보다 작다면 s를 늘려주고           |
    |                             크다면 e를 줄려준다           |
    #===========================================================#
    */
	nums.sort((a, b) => a - b);
	return nums.reduce((res, cur, idx) => {
		let s = idx + 1;
		let e = nums.length - 1;
		while (s < e) {
			if (nums[s] + nums[e] < cur * -1) {
				s++;
			} else if (nums[s] + nums[e] > cur * -1) {
				e--;
			} else {
				let isDup = false;
				for (let i = 0; i < res.length; i++) {
					const [a, b, c] = res[i];
					if (cur === a && nums[s] === b && nums[e] === c) {
						isDup = true;
						break;
					}
				}
				if (!isDup) res.push([cur, nums[s], nums[e]]);
				s++;
				e--;
			}
		}
		return res;
	}, []);
};
