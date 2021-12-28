//CREATE AT: 2021-12-27

//节流
function throttle(func, wait) {
    let start = Date.now();
    let ctx = this;
    return function (...args) {
        let end = Date.now();
        if (end - start >= wait) {
            func.call(ctx, args)
            start = end
        }
    }
}
