var subsets = function (nums) {
	/*////////////////////////////////////////////////////////////
    풀이 방식
    --------------------------------------------------------------
    재귀를 통해 subset을 구하는 방식
    0개부터 nums의 전체 개수만큼의 서브셋을 구한다.
    즉, 길이가 0인 서브셋, 1인 서브셋, ... nums.length인 서브셋
    ////////////////////////////////////////////////////////////*/
	const ans = [];
	for (let i = 0; i <= nums.length; i++) {
		ans.push(...getSubset(nums, i, 0, [], []));
	}
	return ans;

	/*////////////////////////////////////////////////////////////
    솔루션 풀이 방식
    --------------------------------------------------------------
    비트마스크를 이용한 방식
    nums의 길이만큼 비트마스크를 만들고 1씩 더한다.
    만약 nums의 길이가 3이라면, 000 ~ 111 까지 진행하며 
    비트가 1인 자리의 수들을 서브셋에 추가한다.
    예시 nums = [1,2,3] -> bitmask : 000 ~ 111
    000 -> []
    001 -> [3]
    010 -> [2]
    011 -> [2,3]
    100 -> [1]
    101 -> [1,3]
    110 -> [1,2]
    111 -> [1,2,3]
    
    여기서 중요한 부분은 000~111을 할 때 0 ~ 8까지 한다면
    비트마스크 앞에 0을 추가해주어야 한다.
    그렇기 때문에 9 ~ 16 즉 1000 ~ 1111에서 맨 앞자리는 자르고
    사용한다면 앞에 0을 추가하는 로직이 필요없어진다.
    ////////////////////////////////////////////////////////////*/
	const n = nums.length;
	const arr = [];
	for (let i = Math.pow(2, n); i < Math.pow(2, n + 1); i++) {
		const bitmask = i.toString(2).substring(1).split('');

		arr.push(
			bitmask.reduce((sub, bit, idx) => {
				if (bit === '1') sub.push(nums[idx]);
				return sub;
			}, [])
		);
	}
	return arr;
};

var getSubset = function (nums, max, n, arr, sets) {
	if (max === arr.length) {
		sets.push([...arr]);
		return sets;
	}
	for (let i = n; i < nums.length; i++) {
		arr.push(nums[i]);
		getSubset(nums, max, i + 1, arr, sets);
		arr.pop();
	}
	return sets;
};
