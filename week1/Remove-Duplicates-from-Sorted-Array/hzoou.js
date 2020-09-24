function removeDuplicates(numbers) {
  let index = 0;
  numbers.forEach((number, i) => {
    if (numbers.indexOf(number) === i) {
      numbers[index++] = number;
    }
  })

  return index;
};