//============================================================
// 접근 방법 1
// 모든 함수가 O(1)에 가깝도록 만들어야 하는데
// 삽입과 삭제는 가능해도 랜덤이 가능할지는 의문...
// 이점은 스터디때 논의
//============================================================

/**
 * Initialize your data structure here.
 */
var RandomizedSet = function () {
	this.set = {};
};

/**
 * Inserts a value to the set. Returns true if the set did not already contain the specified element.
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function (val) {
	if (this.set[val] !== undefined) return false;
	this.set[val] = true;
	return true;
};

/**
 * Removes a value from the set. Returns true if the set contained the specified element.
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.remove = function (val) {
	if (this.set[val] === undefined) return false;
	delete this.set[val];
	return true;
};

/**
 * Get a random element from the set.
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function () {
	const keys = Object.keys(this.set);
	const rand = Math.floor(Math.random() * keys.length);
	return keys[rand];
};
