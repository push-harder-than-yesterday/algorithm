/* 
#===========================================================# 
| 접근 방식 1                                               | 
|-----------------------------------------------------------|
| 기존 stack과 동일하게 구현                                |
| getMin 메소드의 경우, 스택 값 중 가장 작은 수를 찾음      |
|                                                           |
| 혹은 pop, push 동작에서 min 값을 트래킹 하면 가지고 있음  |
#===========================================================#
*/

/**
 * initialize your data structure here.
 */
var MinStack = function () {
	this.nums = [];
	this.minNum = Infinity;
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function (x) {
	this.nums.push(x);
	this.minNum = Math.min(this.minNum, x);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
	const poppedValue = this.nums.pop();
	if (poppedValue === this.minNum) {
		this.minNum = Infinity;
		for (let i = 0; i < this.nums.length; i++) {
			this.minNum = Math.min(this.nums[i], this.minNum);
		}
	}
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
	return this.nums[this.nums.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
	// let min = Infinity;
	// for(let i = 0; i < this.nums.length; i++){
	//     min = Math.min(this.nums[i], min);
	// }
	// return min;
	return this.minNum;
};
