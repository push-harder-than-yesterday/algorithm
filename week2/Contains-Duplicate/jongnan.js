var containsDuplicate = function (nums) {
	// 처음 접근 방식
	// 내장되어있는 Set을 사용하여 중복을 삭제하고 이 개수와 기존 배열의 개수 확인
	// nums를 한번만 돌고 개수들만 확인하면 되므로 O(n) 시간이 걸림
	const noDuplicateNums = new Set(nums);
	return noDuplicateNums.size !== nums.length;

	// Set 그 외 방식
	// 위 방식처럼 처음에 다 넣지 않고 순차적으로 처리하면서 중복된 것을 찾을 수 도 있음
	const noDuplicateNums = new Set();
	for (let num of nums) {
		if (noDuplicateNums.has(num)) return true;
		noDuplicateNums.add(num);
	}
	return false;

	// 다른 방식
	// 우선 배열을 정렬하고 같은 수가 존재하는지 확인
	// 최악의 경우 배열의 끝까지 다 확인해야하므로 O(n) 시간이 걸림
	nums.sort((a, b) => a - b);
	for (let i = 0; i < nums.length - 1; i++) {
		if (nums[i] === nums[i + 1]) return true;
	}
	return false;
};
