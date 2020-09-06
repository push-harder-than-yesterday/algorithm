var removeDuplicates = function (nums) {
	// 처음 접근 코드
	// 방식 : 처음 만난 수의 첫번째 수와 마지막 수의 위치를 알아내어 두번째 ~ 마지막까지 삭제
	// let curIdx = 0;
	// while(true){
	//     if(curIdx === nums.length) return curIdx;
	//     const endIdx = nums.lastIndexOf(nums[curIdx]);
	//     if(curIdx !== endIdx){
	//         nums.splice(curIdx + 1, endIdx - curIdx);
	//     }
	//     curIdx++;
	// }

	// 두번째
	// 방식 : Set을 사용하여 중복을 없앤 값들을 items로 나두고 기존 nums는 전부 삭제
	// nums.splice(0, nums.length, ...new Set(nums));

	// 세번째
	// 방식 : 현재 위치(idx)에 들어갈 값을 지정하는 방식으로
	//       만약 idx 위치에 있는 값과 다른 값이 나올시 다음 위치(idx + 1)에 그 값으로 변경
	// 예시 : [1,1,1,1,2] 라는 입력이 들어왔을 시에 첫 idx는 0이므로 nums[idx] = 0;
	//       for문을 돌면서 j가 4까지 가게 되고 nums[j] = 2이므로 nums[idx] !== nums[j]가 됨
	//       nums[j]값을 다음 위치인 nums[idx+1]에 저장
	//       모든 값을 돌때까지 이를 반복
	//       예시 배열은 [1,2,1,1,1]과 같이 변경되고, 반환값을 2(idx + 1)를 주어 2번째 전까지 출력
	if (nums.length === 0) return 0;
	let idx = 0;
	for (let i = 1; i < nums.length; i++) {
		if (nums[idx] !== nums[i]) {
			nums[++idx] = nums[i];
		}
	}
	return idx + 1;
};
