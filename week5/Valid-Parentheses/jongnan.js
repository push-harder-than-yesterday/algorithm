var isValid = function (s) {
	/* 
    #===========================================================# 
    | 접근 방식 1                                               | 
    |-----------------------------------------------------------|
    | 스택을 사용하여 상단의 브라켓의 종류를 파악하고 팝과 푸시 |
    | 문자열을 다 돌았을 때 스택에 브라켓이 남아있을 경우,      |
    | 잘못된 문자열                                             |
    #===========================================================#
    */
	const stack = [];
	s.split('').forEach((val) => {
		if (stack.length !== 0) {
			if (
				(val === ')' && stack[stack.length - 1] === '(') ||
				(val === '}' && stack[stack.length - 1] === '{') ||
				(val === ']' && stack[stack.length - 1] === '[')
			) {
				stack.pop();
				return;
			}
		}
		stack.push(val);
	});
	return stack.length === 0;
};
