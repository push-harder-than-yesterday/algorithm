//============================================================
// 접근 방법 1
// 모든 함수가 O(1)에 가깝도록 만들어야 하는데
// 삽입과 삭제는 가능해도 랜덤이 가능할지는 의문...
// 이점은 스터디때 논의
//
// 논의 결과
// 배열, map, idx를 가지고 있음.
// 배열 : 랜덤에서 O(1)로 접근하기 위해 사용
// map : insert, delete를 O(1)로 접근하기 위해 사용
// idx : 배열의 끝부분을 계속해서 가르킴
// 값을 삭제할 때는 배열에서 직접 삭제하는 것이 아니라
// 맨 마지막 인덱스와 삭제할 인덱스의 값을 변경하고
// 마지막 인덱스에 접근할 수 없도록 idx값을 줄여준다.
// 이는 삽입될 때 새로운 값으로 변경되므로 상관 없다.
//============================================================

/**
 * Initialize your data structure here.
 */
var RandomizedSet = function () {
	this.set = {};
	this.arr = new Array(1000000).fill(null);
	this.idx = 0;
};

/**
 * Inserts a value to the set. Returns true if the set did not already contain the specified element.
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function (val) {
	if (this.set[val] !== undefined) return false;
	this.set[val] = this.idx;
	this.arr[this.idx++] = val;
	return true;
};

/**
 * Removes a value from the set. Returns true if the set contained the specified element.
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.remove = function (val) {
	if (this.set[val] === undefined) return false;
	// 삭제할 값의 idx를 찾는다.
	const i = this.set[val];
	// 삭제할 인덱스가 마지막 값이 아니라면 마지막 값과 이를 바꾸고
	// set안에도 이를 변경시켜준다.
	if (i !== this.idx - 1) {
		this.arr[i] = this.arr[this.idx - 1];
		this.set[this.arr[i]] = i;
	}
	//삭제할 값을 삭제하고 idx를 줄여준다.
	delete this.set[val];
	this.idx--;
	return true;
};

/**
 * Get a random element from the set.
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function () {
	const rand = Math.floor(Math.random() * this.idx);
	return this.arr[rand];
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */
