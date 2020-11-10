/*
풀이 방법
----------------------------------------------------
Hashmap을 사용

Hashmap을 사용하여 요소들의 개수를 파악한 뒤, Hashmap을
돌면서 nums 길이의 반 이상이 넘는다면 선택하는 방식이다.
 */
var majorityElement = function (nums) {
	const cond = Math.ceil(nums.length / 2);
	const numMap = nums.reduce((obj, n) => {
		if (obj[n] === undefined) {
			obj[n] = 1;
		} else {
			obj[n] += 1;
		}
		return obj;
	}, {});
	return Object.keys(numMap).reduce((result, num) => {
		if (cond <= numMap[num]) {
			result = num;
		}
		return result;
	}, -Infinity);
};

/*
솔루션 풀이 방법
----------------------------------------------------
정렬을 사용

nums를 정렬했을 때, nums의 길이에 반 이상인 요소들은
무조건 정중앙에 위치한다.
 */
var majorityElement = function (nums) {
	return nums.sort((p, n) => p - n)[Math.floor(nums.length / 2)];
};
