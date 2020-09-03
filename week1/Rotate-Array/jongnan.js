var rotate = function (nums, k) {
	// 처음 접근 방식
	// k만큼 하나씩 빼고 하나씩 집어 넣기
	// for(let i = 0; i < k; i++){
	//     const temp = nums.pop();
	//     nums.unshift(temp);
	// }

	// 다른 방법
	// 배열의 뒤에서부터 k만큼 짤라 앞에 붙히기
	// 대신 k가 배열 길이보다 클 경우, 배열 크기 만큼 나눈 나머지만 사용(배열 크기만큼 돌리면 원상태이므로)
	const moved = nums.splice(nums.length - k, k);
	nums.unshift(...moved);
};
