var intersect = function (nums1, nums2) {
	// 처음 접근 방식

	// 피배열  : 비교를 당할 배열 -> 크기가 큰 배열
	// 비교배열 : 비교를 할 배열  -> 크기가 작은 배열

	// if(nums1.length >= nums2.length){
	//     return searchInterSection(nums2, nums1);
	// }
	// return searchInterSection(nums1, nums2);

	// 다른 접근 방식 1
	// nums1 순서대로 nums2에 해당 값이 존재한다면 결과값에 추가
	// nums2에서 중복된 수가 있기 때문에 해당 값을 사용했는지의 여부 배열도 만들어준다.

	nums2 = [...nums2.map((v) => [v, false])];
	return nums1.reduce((result, num) => {
		for (let i = 0; i < nums2.length; i++) {
			const [comp, used] = nums2[i];
			if (used) continue;
			if (num === comp) {
				result.push(num);
				nums2[i][1] = true;
				break;
			}
		}
		return result;
	}, []);

	// 다른 접근 방식 2
	// 1과 동작은 같으나 reduce말고 filter를 사용, 사용 확인 여부 대신 해당 위치 값을 문자로 변경
	return nums1.filter((num) => {
		const findIdx = nums2.indexOf(num);
		if (findIdx === -1) return false;
		nums1.splice(findIdx, 1, 'Used');
		return true;
	});
};

// 비교배열에서 순서대로 탐색을 시작하며 피배열에서 해당 수들을 찾고 그 위치부터 시작
// 비교배열 : [4,9,5] 피배열 : [9,4,9,8,4] 이라면
// 비교배열 = 4(0), 피배열 = 4(1) 에서 탐색을 시작 및 결과값에 추가

// 다음 수를 비교하여 같은 수 혹은 배열이 끝날때까지 진행
// 비교배열 = 9(1), 피배열 = 9(2) 은 같으니 결과값에 추가

// 비교배열 = 5(2), 피배열 = 8(3) 은 다르므로 비교 끝

// 결과값은 [4,9] 도출

// 여기서 잘못된 점은 만약 피배열이 [9,4,9,8,4,5] 이라면 해당 알고리즘은 똑같이 [4,9]만 도출하나
// 실제 답에서는 [4,9,5]가 도출되므로 틀림
// 즉, 띄어져 숫자가 존재해도 겹치는 수이므로 결과값에 추가 해야됨

const searchInterSection = function (comp, beComped) {
	return comp.reduce((inter, compNum, idx) => {
		for (let i = 0; i < beComped.length; i++) {
			if (compNum !== beComped[i]) continue;

			let becompedIdx = i;
			let compIdx = idx;

			const arr = [beComped[becompedIdx]];

			while (true) {
				if (++becompedIdx >= beComped.length || ++compIdx >= comp.length) break;
				if (beComped[becompedIdx] !== comp[compIdx]) break;
				arr.push(beComped[becompedIdx]);
			}
			if (inter.length < arr.length) inter = [...arr];
		}
		return inter;
	}, []);
};
