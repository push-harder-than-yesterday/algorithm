/*
풀이 방법
----------------------------------------------------
Stack 사용

Postfix 방식(왼 -> 오 -> 루트)이므로 연산자가 나오면
앞에 나온 최근 2개의 숫자를 해당 연산자로 계산하면 된다.
따라서 스택을 사용하면 편리하다.

방법은 다음과 같다.
1. 숫자가 나온다면 스택에 쌓음
2. 연산자가 나온다면 스택 상위 2개 값을 계산 후 
    다시 스택에 쌓음

 */
var evalRPN = function (tokens) {
	const stack = [];
	tokens.forEach((t) => {
		if (t === '+' || t === '-' || t === '*' || t === '/') {
			const a = stack.pop();
			if (t === '+') {
				stack[stack.length - 1] += a;
			} else if (t === '-') {
				stack[stack.length - 1] -= a;
			} else if (t === '*') {
				stack[stack.length - 1] *= a;
			} else {
				stack[stack.length - 1] = Math.trunc(stack[stack.length - 1] / a);
			}
			return;
		}
		stack.push(+t);
	});
	return stack[stack.length - 1];
};
