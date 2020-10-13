/* 
#===========================================================================================# 
| 접근 방식 1                                                                               | 
|-------------------------------------------------------------------------------------------|
| reset 함수의 경우, origin이란 원본 배열을 저장하는 공간을 따로                            |
| 만들고 이를 통해 원본으로 복귀                                                            |
|                                                                                           |
| shuffle 함수의 경우, 새로운 배열에 숫자들을 복사 해놓고 배열 크기만큼 랜덤 숫자를 생성    |                             
| 랜덤으로 생성된 인덱스를 반환할 배열에 넣고, 새롭게 만든 배열에서는 해당 인덱스 값을 삭제 |
#===========================================================================================#
*/

/**
 * @param {number[]} nums
 */
var Solution = function (nums) {
	this.numArr = [...nums];
	this.origin = [...nums];
};

/**
 * Resets the array to its original configuration and return it.
 * @return {number[]}
 */
Solution.prototype.reset = function () {
	this.numArr = [...this.origin];
	return this.numArr;
};

/**
 * Returns a random shuffling of the array.
 * @return {number[]}
 */
Solution.prototype.shuffle = function () {
	const arr = [...this.numArr];
	this.numArr = [];
	while (arr.length !== 0) {
		const ran = Math.floor(Math.random() * arr.length);
		this.numArr.push(arr[ran]);
		arr.splice(ran, 1);
	}
	return this.numArr;
};
