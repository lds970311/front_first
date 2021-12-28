//CREATE AT: 2021-12-27

//防抖函数

function debounce(fn, wait) {
    // let ctx = this;
    let ctx = this;
    let timer;
    return function (...args) {
        if (timer) {
            clearTimeout(timer)
        }
        timer = setTimeout(() => {
            fn.call(ctx, args)
            timer = null;
        }, wait)
    }
}
