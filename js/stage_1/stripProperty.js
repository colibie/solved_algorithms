function getFixedCounter(k) {
  // write your code here
  const counter = (function counter() {
    let value = 0;
    return {
        getValue: function() {
        return value;
        },
        changeBy: function(k) {
        value += k;
        },
    }
    })();
    const res = {}
    res.increment = function() {
        return counter.changeBy(k);
    }
    res.decrement = function() {
        return counter.changeBy(-k);
    }
    res.getValue = function() {
        return counter.getValue();
    }
    return res;
}

const data = getFixedCounter(5);
data.increment();
console.log(data.getValue());