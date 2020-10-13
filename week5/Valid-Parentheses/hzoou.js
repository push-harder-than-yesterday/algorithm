function isValid(s) {
  const brackets = s.split("");
  const stack = [];

  for (const bracket of brackets) {
    if (bracket === "(") {
      stack.push(")");
    } else if (bracket === "[") {
      stack.push("]");
    } else if (bracket === "{") {
      stack.push("}");
    } else if (bracket !== stack.pop()) {
      return false;
    }
  }

  return !stack.length;
}

function isValid(s) {
  const pairs = {
    "(": ")",
    "[": "]",
    "{": "}"
  };
  const brackets = s.split("");
  const stack = [];

  for (const bracket of brackets) {
    if (bracket in pairs) {
      stack.push(pairs[bracket])
    } else if (bracket !== stack.pop()) {
      return false;
    }
  }

  return !stack.length;
}

console.log(isValid("()"));
console.log(isValid("()[]{}"));
console.log(isValid("(]"));
console.log(isValid("([)]"));
console.log(isValid("{[]}"));
console.log(isValid("{}["));