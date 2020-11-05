/*////////////////////////////////////////////////////////////////
풀이 방식
------------------------------------------------------------------
간단한 조합 문제로 재귀를 사용한다.
같은 숫자가 중복되면 안되므로 이미 있는 수를 체크한다.
////////////////////////////////////////////////////////////////*/
var permute = function (nums) {
	return recursion(nums, 0, [], []);
};

var recursion = function (nums, dep, perm, result) {
	if (nums.length === perm.length) {
		if (nums.length === 0) return result;
		result.push([...perm]);
		return result;
	}
	for (let i = 0; i < nums.length; i++) {
		if (perm.indexOf(nums[i]) !== -1) continue;
		perm.push(nums[i]);
		recursion(nums, i, perm, result);
		perm.pop();
	}
	return result;
};
