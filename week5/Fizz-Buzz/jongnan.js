/* 
#==================================# 
| 접근 방식 1                      | 
|----------------------------------|
| 3으로 나눌 수 있다면 Fizz 추가   |                 
| 5로 나눌 수 있다면 Buzz 추가     |
| 둘 다 아니라면 해당 숫자 추가    |
#==================================#
*/

var fizzBuzz = function (n) {
	const result = [];
	for (let i = 1; i <= n; i++) {
		let str = '';
		if (i % 3 === 0) {
			str += 'Fizz';
		}
		if (i % 5 === 0) {
			str += 'Buzz';
		}
		if (str === '') str += i;
		result.push(str);
	}
	return result;
};
