function fib(n: number) {
    if (n === 0 || n === 1) {
        return n;
    }
    let first = 0;
    let second = 1;
    let result = 0
    for (let i = 0; i <= n - 2; i++) {
        first = second
        second = result
        result = first + second
    }
    return result;
}

console.log(fib(6))
