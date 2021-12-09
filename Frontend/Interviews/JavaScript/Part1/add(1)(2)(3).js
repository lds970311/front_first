//CREATE AT: 2021-12-09

/**
 * 函数柯里化
 */
//add(1)(2)(3) = 6

// console.log(getResult(1, 2, 3, 4))
function add(a) {
    function inner(b) {
        a = a + b;
        return inner
    }

    inner.toString = function () {
        return a
    }
    return inner
}


console.log(add(1)(2)(3)(4))
