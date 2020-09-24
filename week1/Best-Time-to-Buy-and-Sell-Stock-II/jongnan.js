var maxProfit = function (prices) {
	// 처음 접근 방식
	// 2중 for문을 사용하여 바깥 for문은 사는 위치이며, 안쪽 for문은 파는 위치로 하여 접근하려 했으나,
	// 이후 어떻게 접근을 해야될지 감이 잡히지 않음
	// for(let i = 0; i < prices.length - 1; i++){
	//      for(let j = i + 1; j < prices.length; j++){
	//      }
	// }

	// solution에서 제시한 접근 방법

	// 1. 모든 경우의 수 해보기.
	// 이 방법은 O(n^n)이므로 시간 초과가 발생

	// 2. 봉우리와 계곡 구간 찾기.
	// 전체 구간을 한번만 돌면서 저점으로가다 고점으로 변경되는 구간을 계곡이라하고 사는 구간이며,
	// 고점으로 가다 저점으로 변경되는 구간을 봉우리라고 하고 파는 구간이 된다.
	// 여기서도 방법이 갈릴 수 있는데 제일 고점을 찾느냐 아니면 봉우리를 찾을때까지 구간을 더하느냐 이다.
	// 두 방법 다 한번만 스캔하므로 O(n) 시간이 걸린다.

	// 2-1. 저점과 그 저점과 가장 가까운 고점을 찾기
	// let i = 0;
	// let valley = prices[i], peak = prices[i];
	// let maxProfit = 0;
	// while(i < prices.length - 1) {
	//     while(i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
	//     valley = prices[i];
	//     while(i < prices.length - 1 && prices[i] < prices[i + 1]) i++;
	//     peak = prices[i];
	//     maxProfit += (peak - valley);
	// }
	// return maxProfit;

	// 2-2. 우리가 구하려는 이득 부분은 저점에서 고점의 차이이다.
	//      즉, 저점에서 고점으로 가는 구간의 합이나 고점 - 저점이나 같은 값을 가진다.
	//      저점에서 고점으로 가는 구간인지는 현재 값과 다음 값의 차이를 보면 알 수 있다.
	let maxProfit = 0;
	for (let i = 0; i < prices.length - 1; i++) {
		if (prices[i] < prices[i + 1]) maxProfit += prices[i + 1] - prices[i];
	}
	return maxProfit;
};
