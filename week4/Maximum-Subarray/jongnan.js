var maxSubArray = function (nums) {
	/* 
    #==================================================================================# 
    | 접근 방식 1                                                                      | 
    |----------------------------------------------------------------------------------|
    | 위 힌트로 분할 정복을 사용하라고 되어 있어 생각해 보았지만,                      |
    |중간 subArr들을 어떻게 구해야 할 지 잘 모르겠음.                                  |
    |                                                                                  |
    | divide and conquer subarray 를 구글링해보니 많은 영상을 볼 수 있었고 힌트를 얻음 |
    |                                                                                  |
    | 일단 반으로 쪼개면서 왼쪽 부분배열과 오른쪽 부분배열 중 최대 값을 구하는 것      |
    | 그 반으로 쪼개는 위치 기준으로 전체 배열의 왼쪽 부분                             |
    | 그리고 오른쪽 부분의 점차적인 합을 비교하며 중간 부분배열의 최대값을 구하는 것   |
    |                                                                                  |
    | 1 2 3 4 5 6 7 이란 배열이 있을 경우                                              |
    | 1 2 3 | 4 5 6 7 로 나뉨                                                          |
    | 이때, 중간 부분배열의 합은 다음과 같이 계산                                      |
    | 1+2+3 2+3 3 | 4 4+5 4+5+6 4+5+6+7                                                |
    | 왼쪽에서 최대값 위치 ~ 오른쪽에서 최대값 위치 가 현재 기준으로 가장 큰 부분배열  |
    #==================================================================================#
    */
	return dac(nums, 0, nums.length - 1);
};
function crossSubArray(nums, mid) {
	let maxLeft = -Infinity,
		maxRight = -Infinity;
	let sum = 0;
	for (let i = mid; i >= 0; i--) {
		sum += nums[i];
		maxLeft = Math.max(maxLeft, sum);
	}
	sum = 0;
	for (let i = mid + 1; i < nums.length; i++) {
		sum += nums[i];
		maxRight = Math.max(maxRight, sum);
	}
	return Math.max(maxLeft + maxRight, maxLeft, maxRight);
}

function dac(nums, l, r) {
	if (l === r) return nums[l];
	const mid = Math.floor((l + r) / 2);
	const left = dac(nums, l, mid);
	const right = dac(nums, mid + 1, r);
	const cross = crossSubArray(nums, mid);
	return Math.max(left, right, cross);
}
