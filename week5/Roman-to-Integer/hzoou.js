function romanToInt(string) {
  const roman = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000
  };
  const strings = string.split("");

  return strings.reduce((acc, cur, i) => {
    if (cur === "I" ) {
      if (strings[i + 1] === "V" || strings[i + 1] === "X") {
        return acc - 1;
      }
    } else if (cur === "X") {
      if (strings[i + 1] === "L" || strings[i + 1] === "C") {
        return acc - 10;
      }
    } else if (cur === "C") {
      if (strings[i + 1] === "D" || strings[i + 1] === "M") {
        return acc - 100;
      }
    }
    return acc + roman[cur];
  }, 0)
}

function romanToInt(string) {
  const roman = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000
  };
  const strings = string.split("");

  return strings.reduce((acc, cur, i) => {
    const current = roman[cur];
    const next = roman[string[i + 1]] || 0;

    if (current >= next) {
      return acc + current;
    }
    return acc - current;
  }, 0)
}

console.log(romanToInt("III"));
console.log(romanToInt("IV"));
console.log(romanToInt("IX"));
console.log(romanToInt("LVIII"));
console.log(romanToInt("MCMXCIV"));