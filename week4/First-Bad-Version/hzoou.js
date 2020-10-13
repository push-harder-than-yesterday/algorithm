function solution(isBadVersion) {
  return function (n) {
    for (let i = 1; i < n; i++) {
      if (isBadVersion(i)) return i;
    }
    return n;
  };
}

function solution(isBadVersion) {
  return function (n) {
    let start = 1, end = n;

    while (start < end) {
      let mid = Math.floor((start + end) / 2);
      if (isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    return start;
  };
}