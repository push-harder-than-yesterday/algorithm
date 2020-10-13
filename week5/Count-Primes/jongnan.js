/* 
#=================================================# 
| 접근 방식 1                                     | 
|-------------------------------------------------|
| 에라토스테네스의 체를 사용                      |
| 2가 시작되면 cnt 증가시키고 2의 배수들을 삭제   |
| 3이 시작되면 똑같이 반복                        |
| 만약, 해당 값이 삭제된 값이라면 작업을 건너 뜀  |
#=================================================#
*/

var countPrimes = function (n) {
	const numsArr = new Array(n).fill(0).map((_, idx) => idx);
	let num = 2;
	let cnt = 0;
	while (num < n) {
		if (numsArr[num] === -1) {
			num++;
			continue;
		}
		cnt++;
		numsArr[num] = -1;
		let mul = 2;
		while (num * mul < n) {
			if (numsArr[num * mul] === -1) {
				mul++;
				continue;
			}
			numsArr[num * mul] = -1;
			mul++;
		}
		num++;
	}
	return cnt;
};
