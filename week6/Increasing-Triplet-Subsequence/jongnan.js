var increasingTriplet = function (nums) {
	/* 
    #===========================================================# 
    | 접근 방식 1                                               | 
    |-----------------------------------------------------------|
    | 방법을 찾지 못해 구글링을 해서 품                         |
    |                                                           |
    | 총 3개의 수만 필요하므로 따로 저장하여 관리               |
    | 첫번째 수는 nums의 가장 첫번째 수로 지정하고              |
    | 두번째 수와 세번째 수는 for문을 돌면서 찾아감             |
    | 세번째수는 따로 정하지 않아도 되는 이유는 찾자 마자 바로  |
    | 정답을 출력하면 되기 때문                                 |
    | true가 될 수 있는 경우는 second 값보다 세번째 수 즉, 현재 |
    | for문에서의 nums[i]가 클 경우 true를 반환                 |
    | 만약 세번째 수가 첫번째 수보다 작다면 새로 갱신           |
    |                  첫번째 수보다 크다면 second로 갱신       |
    #===========================================================#
    */
	let first = nums[0];
	let second = Infinity;
	for (let i = 1; i < nums.length; i++) {
		if (nums[i] > second) {
			return true;
		}
		if (nums[i] < first) {
			first = nums[i];
			continue;
		}
		if (nums[i] > first) {
			second = nums[i];
			continue;
		}
	}
	return false;
};
