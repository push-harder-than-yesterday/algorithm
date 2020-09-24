function reverseString(strings) {
  const count = parseInt(strings.length / 2, 10);
  let index = 0;

  while (index < count) {
    const lastIndex = strings.length - index - 1;
    const left = strings[index];
    const right = strings[lastIndex];

    strings[index++] = right;
    strings[lastIndex] = left;
  }

  return strings;
};