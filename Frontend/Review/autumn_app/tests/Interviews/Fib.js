function fib(n) {
    if (n === 0 || n === 1) {
        return n;
    }
    var first = 0;
    var second = 1;
    var result = 0;
    for (var i = 0; i <= n - 2; i++) {
        first = second;
        second = result;
        result = first + second;
    }
    return result;
}
console.log(fib(6));
