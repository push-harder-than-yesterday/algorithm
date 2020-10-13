var solution = function (isBadVersion) {
	/**
	 * @param {integer} n Total versions
	 * @return {integer} The first bad version
	 */

	/* 
    #===============================================================# 
    | 접근 방식 1                                                   | 
    |---------------------------------------------------------------|
    | 1 ~ n까지 하나씩 확인하면서 BadVersion 찾기 => 시간초과(14억) |
    #===============================================================#
    */
	return function (n) {
		for (let i = 1; i <= n; i++) {
			if (isBadVersion(i)) return i;
		}
	};

	/* 
    #=========================================================================# 
    | 접근 방식 2                                                             | 
    |-------------------------------------------------------------------------|
    | 이분 탐색을 통해 확인                                                   |
    | 최종 값을 선택하기 위해서는 이전 버전도 확인                            |
    | 현재 버전부터 Bad를 찾아야 하므로 false -> true로 변경되는 경계값을 찾기|
    |                                                                         |
    | # 주의할 점!                                                            |
    | 이전 값을 확인해야되므로 1일때는 0을 확인                               |
    | 0은 없는 값이므로 1이 bad인지 확인하고 bad라면 그대로 1을 리턴          |
    | bad가 아니라면 2부터 다시 확인                                          |
    #=========================================================================#
    */
	return function (n) {
		let low = 1,
			high = n;
		while (low < high) {
			let mid = Math.floor((low + high) / 2);
			if (mid - 1 <= 0) {
				if (isBadVersion(mid)) return mid;
				low = mid + 1;
				continue;
			}
			if (isBadVersion(mid) && isBadVersion(mid - 1)) {
				high = mid - 1;
				continue;
			}
			if (!isBadVersion(mid) && !isBadVersion(mid - 1)) {
				low = mid + 1;
				continue;
			}
			if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
				return mid;
			}
		}
	};

	/* 
    #=========================================================================================# 
    | 솔루션 접근 방식                                                                        | 
    |-----------------------------------------------------------------------------------------|
    | 솔루션에서도 이분 탐색 사용                                                             |
    | 하지만, 이전 값을 확인하면서 경계값을 찾는 것이 아닌 left, right만으로 경계값을 찾음    |
    | bad 버전일 경우 그 아래, bad 버전이 아닐 겨우 그 위를 탐색해 나아가면 결국 경계값을 찾음|
    #=========================================================================================#
    */

	return function (n) {
		let left = 1,
			right = n;
		while (left < right) {
			let mid = Math.floor((left + right) / 2);
			if (isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	};
};
