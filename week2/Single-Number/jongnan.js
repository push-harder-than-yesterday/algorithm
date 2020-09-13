var singleNumber = function (nums) {
	// 처음 접근 방식
	// Map을 사용하여 1개인 수를 찾음
	// nums를 한번 돌면서 Map에 넣기, Map을 돌면서 1인 수 찾기이므로 O(n) 시간이 걸림
	const numsMap = new Map();
	nums.forEach((num) => {
		if (numsMap.has(num)) {
			numsMap.set(num, numsMap.get(num) + 1);
		} else {
			numsMap.set(num, 1);
		}
	});

	for (let [key, val] of numsMap) {
		if (val === 1) {
			return key;
		}
	}

	// 다른 방법(solution)

	// 1. 수학적으로 접근하기
	// 각 수를 2번씩 다 더한 값에 nums를 다 더한 값을 빼면 하나인 수가 도출
	// 2 * (a + b + c) - (a + a + b + b + c) = c
	// Set의 모든 수 더하기, 배열의 모든 수 더하므로 O(n) 시간 걸림
	const numSet = new Set(nums);
	const sum = nums.reduce((s, n) => s + n, 0);
	let sumSet = 0;
	numSet.forEach((n) => (sumSet += n));
	return 2 * sumSet - sum;

	// 2. Bit 연산
	// XOR 연산의 경우 같은 같은 비트일 때는 0, 다른 비트일 경우 1
	// 그렇기에 (A XOR A) = 0, (A XOR 0) = A
	// (A XOR B XOR A) = ((A XOR A) XOR B) = (0 XOR B) = B
	// 이러한 방식으로 1개인 수를 찾음
	// nums를 한번만 돌면 되므로 O(n) 시간 걸림
	return nums.reduce((xor, num) => xor ^ num, 0);
};
