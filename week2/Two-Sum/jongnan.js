var twoSum = function (nums, target) {
	// 처음 접근 방식

	// 해쉬 테이블을 이용
	// key - nums[i] 와 더해서 target을 만들 수 있는 수 ex) num[i] = 2, target = 9 -> key = 7
	// val - [i] 인덱스를 반환해야하므로 인덱스를 저장, 배열 형태인 이유는 같은 수가 여러개 있을 수 있기 때문.
	// 해쉬 테이블을 만들고 난 뒤, nums를 돌면서 키를 확인
	// 해쉬 테이블 만들기 시간 복잡도 : O(n)
	// 키 확인 : O(n)

	const hashTable = nums.reduce((ht, num, idx) => {
		const key = target - num;
		if (!ht[key]) ht[key] = [idx];
		else ht[key].push(idx);
		return ht;
	}, {});

	for (let i = 0; i < nums.length; i++) {
		const idxs = hashTable[nums[i] + ''];
		if (!idxs) continue;
		for (let j = 0; j < idxs.length; j++) {
			if (idxs[j] === i) continue;
			return [i, idxs[j]].sort((a, b) => a - b);
		}
	}

	// 솔루션에서의 접근 방식

	// 해쉬 테이블을 이용하는 것은 똑같으나, 테이블을 작성하는 동시에 확인
	// num이 중복되어도 이는 바로바로 확인하는 것이니 배열로 넣어주거나 할 필요가 없다.

	const hashTable = {};

	for (let i = 0; i < nums.length; i++) {
		if (hashTable[nums[i]] >= 0) {
			return [hashTable[nums[i]], i];
		}
		hashTable[target - nums[i]] = i;
	}
};
