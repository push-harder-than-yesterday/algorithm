function strStr(haystack, needle) {
  if (!needle) return 0;
  return haystack.indexOf(needle)
}

console.log(strStr("hello", "ll"))
console.log(strStr("aaaaa", "bba"))