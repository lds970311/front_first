function clearRepeat(arr) {
    const map = {}
    const result = []
    for (let i = 0; i < arr.length; i++) {
        if (!map[arr[i]]) {
            result.push(arr[i])
            map[arr[i]] = 1
        }
    }
    return result;
}

const arr = [1, 1, 4, 4, 5, 6, 8, 8]
let repeat = clearRepeat(arr);
console.log(repeat);