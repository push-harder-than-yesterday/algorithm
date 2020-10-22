function RandomizedSet() {
  this.set = [];
  this.length = 0;
};

RandomizedSet.prototype.insert = function (val) {
  if (this.set.indexOf(val) !== -1) {
    return false;
  }

  this.set.push(val);
  this.length++;

  return true;
};

RandomizedSet.prototype.remove = function (val) {
  const index = this.set.indexOf(val);

  if (index === -1) {
    return false;
  }

  this.set.splice(index, 1);
  this.length--;

  return true;
};

RandomizedSet.prototype.getRandom = function () {
  const index = Math.floor(Math.random() * this.length);

  return this.set[index]
};