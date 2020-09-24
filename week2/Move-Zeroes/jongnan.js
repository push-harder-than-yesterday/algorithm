var moveZeroes = function (nums) {
	// 처음 접근 방식
	// 한번씩 돌면서 해당 위치의 값이 0이면 그 위치에서 삭제한 뒤 배열 뒤에 추가하고 0이 아니면 다음으로 넘어감
	// 여기서 체크해야될 위치와 여태까지 체크한 개수를 따로 관리해야하는데 이유는 다음과 같음
	// 해당 위치의 값이 0이라면 삭제하며 배열 맨 뒤에 0을 추가
	// 기존 위치의 값이 삭제 되었으므로 한칸씩 앞으로 땡겨지게 되고 다시한번 그 위치를 확인해야됨
	// 반대로 0이 아니라면 한칸 뒤로만 위치를 움직여줌
	// 체크한 개수는 뒤에 쌓인 0들을 만나게 된다면 무한 반복되므로 딱 배열 크기만큼만 체크

	let checkCnt = 0;
	let idx = 0;
	while (true) {
		if (checkCnt >= nums.length) break;
		checkCnt++;
		if (nums[idx] === 0) {
			nums.splice(idx, 1);
			nums.push(0);
			continue;
		}
		idx++;
	}

	// 다른 접근 방식
	// 배열을 돌면서 0이 아닌 값들을 0부터 차근차근 변경하며, 나머지 부분은 0으로 변경한다.

	// 새로 셋팅할 위치 관리
	let settingIdx = 0;
	// 배열 돌기
	for (let i = 0; i < nums.length; i++) {
		// 0이 아닌 값은 셋팅 위치에 저장
		if (nums[i] !== 0) nums[settingIdx++] = nums[i];
	}
	// 나머지 셋팅 위치들에는 0으로 저장
	for (let i = settingIdx; i < nums.length; i++) {
		nums[i] = 0;
	}
};
